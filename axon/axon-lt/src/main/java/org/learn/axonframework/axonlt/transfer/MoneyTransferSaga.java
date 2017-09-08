package org.learn.axonframework.axonlt.transfer;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.StartSaga;
import org.learn.axonframework.axonlt.coreapi.MoneyTransferRequestedEvent;
import org.learn.axonframework.axonlt.coreapi.WithdrawMoneyCommand;

import javax.inject.Inject;

public class MoneyTransferSaga {

    @Inject
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "transferId")
    public void on(MoneyTransferRequestedEvent event) {
        System.out.println(commandGateway);
        commandGateway.send(new WithdrawMoneyCommand(event.getSourceAccount(), event.getAmount()));
    }
}
