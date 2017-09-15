package org.learn.axonframework.orderservice.saga;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.learn.axonframework.coreapi.OrderFiledEvent;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
public class OrderManagementSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void on(OrderFiledEvent event) {

        //request shipment
        commandGateway.send(new RequestShipmentCommand(event.getOrderId(), event.getProductInfo()));

        //create invoice
//        commandGateway.send(new CreateInvoiceCommand(event.getOrderId(), event.getProductId(),
//                event.getComment()), LoggingCallback.INSTANCE);
    }
}
