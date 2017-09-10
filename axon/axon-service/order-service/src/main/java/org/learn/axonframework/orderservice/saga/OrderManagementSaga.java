package org.learn.axonframework.orderservice.saga;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.learn.axonframework.coreapi.CreateInvoiceCommand;
import org.learn.axonframework.coreapi.OrderFiledEvent;
import org.learn.axonframework.coreapi.PrepareShipmentCommand;
import org.learn.axonframework.util.LoggingCallback;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
public class OrderManagementSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void on(OrderFiledEvent event) {

        //send shipment
        commandGateway.send(new PrepareShipmentCommand(event.getOrderId(), event.getProductName(),
                event.getPrice()), LoggingCallback.INSTANCE);

        //create invoice
        commandGateway.send(new CreateInvoiceCommand(event.getOrderId(), event.getProductName(),
                event.getComment()), LoggingCallback.INSTANCE);
    }
}
