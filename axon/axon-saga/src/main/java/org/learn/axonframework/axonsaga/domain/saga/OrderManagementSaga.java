package org.learn.axonframework.axonsaga.domain.saga;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.learn.axonframework.axonsaga.command.model.CompensateShipmentCommand;
import org.learn.axonframework.axonsaga.command.model.CreateInvoiceCommand;
import org.learn.axonframework.axonsaga.command.model.PrepareShippingCommand;
import org.learn.axonframework.axonsaga.event.CompensateOrderSagaEvent;
import org.learn.axonframework.axonsaga.event.CompensateShipmentEvent;
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

    private OrderProcess orderProcess = new OrderProcess();
    private OrderCompensation orderCompensation = new OrderCompensation();

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
        orderProcess.setDelivered(true);
        System.out.println(String.format("shippment %s arrived in SAGA, order: %s", event.getShipmentId(), event.getOrderId()));
        if (orderProcess.isPaid()) {
            finishSaga(event.getOrderId());
        }
    }

    @SagaEventHandler(associationProperty = "invoiceId")
    public void handle(InvoicePaidEvent event) {
        orderProcess.setDelivered(true);
        System.out.println(String.format("invoice %s paid in SAGA, order %s", event.getInvoiceId(), event.getOrderId()));
        if (orderProcess.isDelivered()) {
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

    @SagaEventHandler(associationProperty = "shipmentId")
    public void on(CompensateShipmentEvent event) {
        orderCompensation.setShipmentCompensated(true);
        System.out.println(String.format("shipment %s compensated in SAGA for order [%s] with cause: %s",
                event.getShipmentId(), event.getOrderId(), event.getCause()));

        if (isCompensated()) {
            finishCompensation(event.getOrderId());
        }
    }

    private void finishCompensation(String orderId) {
        end();
        System.out.println(String.format("SAGA with order [%s] fully compensated", orderId));
    }

    private boolean isCompensated() {
        boolean isCompensated = false;

        if (orderProcess.isDelivered()) {
            isCompensated = orderCompensation.isShipmentCompensated();
        }

        if (orderProcess.isPaid()) {
            isCompensated = orderCompensation.isInvoiceCompensated();
        }

        return isCompensated;
    }

    private static class OrderProcess {

        private boolean delivered;
        private boolean paid;

        public OrderProcess() {
        }

        public boolean isDelivered() {
            return delivered;
        }

        public void setDelivered(boolean delivered) {
            this.delivered = delivered;
        }

        public boolean isPaid() {
            return paid;
        }

        public void setPaid(boolean paid) {
            this.paid = paid;
        }
    }

    private static class OrderCompensation {

        private boolean shipmentCompensated;
        private boolean invoiceCompensated;

        public OrderCompensation() {
        }

        public boolean isShipmentCompensated() {
            return shipmentCompensated;
        }

        public void setShipmentCompensated(boolean shipmentCompensated) {
            this.shipmentCompensated = shipmentCompensated;
        }

        public boolean isInvoiceCompensated() {
            return invoiceCompensated;
        }

        public void setInvoiceCompensated(boolean invoiceCompensated) {
            this.invoiceCompensated = invoiceCompensated;
        }
    }
}
