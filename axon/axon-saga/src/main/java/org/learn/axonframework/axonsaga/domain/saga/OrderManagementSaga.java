package org.learn.axonframework.axonsaga.domain.saga;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderManagementSaga {

    private boolean paid = false;
    private boolean delivered = false;

    @Autowired
    private transient CommandGateway commandGateway;
//
//    @StartSaga
//    @SagaEventHandler(associationProperty = "orderId")
//    public void handle(OrderCreatedEvent event) {
//        // client generated identifiers
//        ShippingId shipmentId = createShipmentId();
//        InvoiceId invoiceId = createInvoiceId();
//        // associate the Saga with these values, before sending the commands
//        associateWith("shipmentId", shipmentId);
//        associateWith("invoiceId", invoiceId);
//        // send the commands
//        commandGateway.send(new PrepareShippingCommand(...));
//        commandGateway.send(new CreateInvoiceCommand(...));
//    }
//
//    @SagaEventHandler(associationProperty = "shipmentId")
//    public void handle(ShippingArrivedEvent event) {
//        delivered = true;
//        if (paid) { end(); }
//    }
//
//    @SagaEventHandler(associationProperty = "invoiceId")
//    public void handle(InvoicePaidEvent event) {
//        paid = true;
//        if (delivered) { end(); }
//    }

}
