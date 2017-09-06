package org.learn.axonframework.axonsaga.domain.saga;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.learn.axonframework.axonsaga.command.model.CompensateShipmentCommand;
import org.learn.axonframework.axonsaga.command.model.CreateInvoiceCommand;
import org.learn.axonframework.axonsaga.command.model.PrepareShippingCommand;
import org.learn.axonframework.axonsaga.event.CompensateOrderSagaEvent;
import org.learn.axonframework.axonsaga.event.InvoicePaidEvent;
import org.learn.axonframework.axonsaga.event.OrderFiledEvent;
import org.learn.axonframework.axonsaga.event.ShipmentArrivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static org.axonframework.eventhandling.saga.SagaLifecycle.associateWith;
import static org.axonframework.eventhandling.saga.SagaLifecycle.end;

@Component
@Saga
public class OrderManagementSaga {

    private boolean paid = false;
    private boolean delivered = false;

    private String shipmentId;
    private String invoiceId;

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderFiledEvent event) {
        System.out.println(String.format("starting SAGA for order: %s", event.getOrderId()));
        // client generated identifiers
        shipmentId = UUID.randomUUID().toString();
        invoiceId = UUID.randomUUID().toString();
        // associate the Saga with these values, before sending the commands
        associateWith("shipmentId", shipmentId);
        associateWith("invoiceId", invoiceId);
        // send the commands
        commandGateway.send(new PrepareShippingCommand(shipmentId, event.getOrderId(), event.getProductName(), 10.0));
        commandGateway.send(new CreateInvoiceCommand(invoiceId, event.getOrderId(), event.getProductName(), "test comment"));
    }

    @SagaEventHandler(associationProperty = "shipmentId")
    public void handle(ShipmentArrivedEvent event) {
        delivered = true;
        System.out.println(String.format("shippment %s arrived in SAGA, order: %s", event.getShipmentId(), event.getOrderId()));
        if (paid) {
            finishSaga(event.getOrderId());
        }
    }

    @SagaEventHandler(associationProperty = "invoiceId")
    public void handle(InvoicePaidEvent event) {
        paid = true;
        System.out.println(String.format("invoice %s paid in SAGA, order %s", event.getInvoiceId(), event.getOrderId()));
        if (delivered) {
            finishSaga(event.getOrderId());
        }
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void on(CompensateOrderSagaEvent event) {
        associateWith("shipmentId", shipmentId);
        commandGateway.send(new CompensateShipmentCommand(shipmentId, event.getOrderId(), event.getCause()));
    }

    private void finishSaga(String orderId) {
        end();
        System.out.println(String.format("ending SAGA with order: %s", orderId));
    }


}
