package org.learn.axonframework.axonsaga.domain;

import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.learn.axonframework.axonsaga.command.model.CreateInvoiceCommand;
import org.learn.axonframework.axonsaga.event.CompensateInvoiceEvent;
import org.learn.axonframework.axonsaga.event.CompensateOrderSagaEvent;
import org.learn.axonframework.axonsaga.event.InvoicePaidEvent;

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

        //simulate compensation of saga on error
        if (command.getProductName().equals("compensateSaga")) {
            System.out.println("simulating error for SAGA compensation");
            apply(new CompensateOrderSagaEvent(command.getOrderId(), "shipment failed"));
        } else {
            apply(new InvoicePaidEvent(command.getInvoiceId(), command.getOrderId(), command.getComment()));
        }
    }

    @EventSourcingHandler
    public void on(InvoicePaidEvent event) {
        invoiceId = event.getInvoiceId();
        System.out.println(String.format("invoice %s has been paid", invoiceId));
    }

    @EventHandler
    public void on(CompensateInvoiceEvent event) {
        System.out.println(String.format("invoice %s compensation with cause: %s", invoiceId, event.getCause()));
    }
}
