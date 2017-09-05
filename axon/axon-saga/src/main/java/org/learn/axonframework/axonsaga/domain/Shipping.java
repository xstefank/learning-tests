package org.learn.axonframework.axonsaga.domain;

import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.common.Assert;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.learn.axonframework.axonsaga.command.model.PrepareShippingCommand;
import org.learn.axonframework.axonsaga.event.ShippingArrivedEvent;

import java.util.Random;
import java.util.logging.Logger;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@NoArgsConstructor
@Aggregate
public class Shipping {

    @AggregateIdentifier
    private String shippingId;

    @CommandHandler
    public Shipping(PrepareShippingCommand command) throws InterruptedException {
        //checks
//        Thread.sleep(1000 * (new Random().nextInt(10) + 1));
        apply(new ShippingArrivedEvent(command.getShippingId(), command.getOrderId(), command.getShipingPrice()));
    }

    @EventSourcingHandler
    public void on(ShippingArrivedEvent event) {
        shippingId = event.getShipmentId();
        System.out.println(String.format("Shipping %s arrived", shippingId));
    }
}
