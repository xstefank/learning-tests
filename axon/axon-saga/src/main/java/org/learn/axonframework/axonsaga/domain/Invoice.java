package org.learn.axonframework.axonsaga.domain;

import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.learn.axonframework.axonsaga.command.model.CreateInvoiceCommand;
import org.learn.axonframework.axonsaga.event.InvoicePaidEvent;

import java.util.Random;
import java.util.logging.Logger;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@NoArgsConstructor
@Aggregate
public class Invoice {

    @AggregateIdentifier
    private String invoiceId;

    @CommandHandler
    public Invoice(CreateInvoiceCommand command) throws InterruptedException {
        //simulate check
//        Thread.sleep(1000 * (new Random().nextInt(10) + 1));
        apply(new InvoicePaidEvent(command.getInvoiceId(), command.getOrderId(), command.getComment()));
    }

    @EventSourcingHandler
    public void on(InvoicePaidEvent event) {
        invoiceId = event.getInvoiceId();
        System.out.println(String.format("invoice %s has been paid", invoiceId));
    }
}
