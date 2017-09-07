package org.learn.axonframework.axonsaga.domain;

import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.learn.axonframework.axonsaga.command.model.CompensateShipmentCommand;
import org.learn.axonframework.axonsaga.command.model.PrepareShippingCommand;
import org.learn.axonframework.axonsaga.event.CompensateShipmentEvent;
import org.learn.axonframework.axonsaga.event.ShipmentArrivedEvent;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@NoArgsConstructor
@Aggregate
public class Shipment {

    @AggregateIdentifier
    private String shippingId;

    @CommandHandler
    public Shipment(PrepareShippingCommand command) throws InterruptedException {
        //checks
//        Thread.sleep(1000 * (new Random().nextInt(10) + 1));

        apply(new ShipmentArrivedEvent(command.getShippingId(), command.getOrderId(), command.getShipingPrice()));
    }

    @CommandHandler
    public void on(CompensateShipmentCommand command) {
        System.out.println(String.format("Shipment %s compensation with cause: %s", command.getShipmentId(), command.getCause()));
        apply(new CompensateShipmentEvent(command.getShipmentId(), command.getOrderId(), command.getCause()));
    }

    @EventSourcingHandler
    public void on(ShipmentArrivedEvent event) {
        shippingId = event.getShipmentId();
        System.out.println(String.format("Shipment %s arrived", shippingId));
    }

}
