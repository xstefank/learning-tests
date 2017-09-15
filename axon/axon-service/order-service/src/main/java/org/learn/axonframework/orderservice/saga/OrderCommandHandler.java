package org.learn.axonframework.orderservice.saga;

import org.axonframework.commandhandling.CommandHandler;
import org.learn.axonframework.coreapi.ShipmentRequestedEvent;
import org.springframework.stereotype.Component;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Component
public class OrderCommandHandler {

    @CommandHandler
    public void handle(RequestShipmentCommand command) {
        apply(apply(new ShipmentRequestedEvent(command.getOrderId(), command.getProductInfo())));
    }
}
