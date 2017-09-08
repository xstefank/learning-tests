package org.learn.axonframework.axonlt.transfer;

import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.learn.axonframework.axonlt.coreapi.CancelMoneyTransferCommand;
import org.learn.axonframework.axonlt.coreapi.CompleteMoneyTransferCommand;
import org.learn.axonframework.axonlt.coreapi.MoneyTransferCancelledEvent;
import org.learn.axonframework.axonlt.coreapi.MoneyTransferCompletedEvent;
import org.learn.axonframework.axonlt.coreapi.MoneyTransferRequestedEvent;
import org.learn.axonframework.axonlt.coreapi.RequestMoneyTransferCommand;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;
import static org.axonframework.commandhandling.model.AggregateLifecycle.markDeleted;

@NoArgsConstructor
@Aggregate
public class MoneyTransfer {

    @AggregateIdentifier
    private String transferId;

    @CommandHandler
    public MoneyTransfer(RequestMoneyTransferCommand command) {
        apply(new MoneyTransferRequestedEvent(command.getTransferId(), command.getSourceAccount(), command.getTargetAccount(),
                command.getAmount()));
    }

    @CommandHandler
    public void handle(CompleteMoneyTransferCommand command) {
        apply(new MoneyTransferCompletedEvent(transferId));
    }

    @CommandHandler
    public void handler(CancelMoneyTransferCommand command) {
        apply(new MoneyTransferCancelledEvent(transferId));
    }

    @EventSourcingHandler
    protected void on(MoneyTransferRequestedEvent event) {
        this.transferId = event.getTransferId();
    }

    @EventSourcingHandler
    protected void on(MoneyTransferCompletedEvent event) {
        markDeleted();
    }

}
