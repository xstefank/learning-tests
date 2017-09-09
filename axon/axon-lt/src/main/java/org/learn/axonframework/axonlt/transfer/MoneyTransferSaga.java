package org.learn.axonframework.axonlt.transfer;

import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.saga.EndSaga;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.SagaLifecycle;
import org.axonframework.eventhandling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.learn.axonframework.axonlt.LoggingCallback;
import org.learn.axonframework.axonlt.coreapi.CancelMoneyTransferCommand;
import org.learn.axonframework.axonlt.coreapi.CompleteMoneyTransferCommand;
import org.learn.axonframework.axonlt.coreapi.DepositMoneyCommand;
import org.learn.axonframework.axonlt.coreapi.MoneyDepositedEvent;
import org.learn.axonframework.axonlt.coreapi.MoneyTransferCancelledEvent;
import org.learn.axonframework.axonlt.coreapi.MoneyTransferCompletedEvent;
import org.learn.axonframework.axonlt.coreapi.MoneyTransferRequestedEvent;
import org.learn.axonframework.axonlt.coreapi.MoneyWithdrawnEvent;
import org.learn.axonframework.axonlt.coreapi.OverdraftLimitExceededException;
import org.learn.axonframework.axonlt.coreapi.WithdrawMoneyCommand;

import javax.inject.Inject;

import java.util.UUID;

import static org.axonframework.eventhandling.saga.SagaLifecycle.end;

@Saga
public class MoneyTransferSaga {

    @Inject
    private transient CommandGateway commandGateway;

    private String targetAccount;
    private String transactionId;
    private String transferId;

    @StartSaga
    @SagaEventHandler(associationProperty = "transferId")
    public void on(MoneyTransferRequestedEvent event) {
        targetAccount = event.getTargetAccount();
        transactionId = UUID.randomUUID().toString();
        transferId = event.getTransferId();
        SagaLifecycle.associateWith("transactionId", transactionId);
        commandGateway.send(new WithdrawMoneyCommand(event.getSourceAccount(), transactionId, event.getAmount()),
                new CommandCallback<WithdrawMoneyCommand, Object>() {
                    @Override
                    public void onSuccess(CommandMessage<? extends WithdrawMoneyCommand> commandMessage, Object result) {

                    }

                    @Override
                    public void onFailure(CommandMessage<? extends WithdrawMoneyCommand> commandMessage, Throwable cause) {
                        commandGateway.send(new CancelMoneyTransferCommand(event.getTransferId()));
                    }
                });
    }

    @SagaEventHandler(associationProperty = "transactionId")
    public void on(MoneyWithdrawnEvent event) {
        commandGateway.send(new DepositMoneyCommand(targetAccount, event.getTransactionId(), event.getAmount()),
                LoggingCallback.INSTANCE);
    }

    @SagaEventHandler(associationProperty = "transactionId")
    public void on(MoneyDepositedEvent event) {
        commandGateway.send(new CompleteMoneyTransferCommand(transferId), LoggingCallback.INSTANCE);
    }

    @EndSaga
    @SagaEventHandler(associationProperty = "transferId")
    public void on(MoneyTransferCompletedEvent event) {

    }

    @SagaEventHandler(associationProperty = "transferId")
    public void on(MoneyTransferCancelledEvent event) {
        end();
    }
}
