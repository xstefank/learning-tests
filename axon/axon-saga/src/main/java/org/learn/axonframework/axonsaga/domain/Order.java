package org.learn.axonframework.axonsaga.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.learn.axonframework.axonsaga.command.FileOrderCommand;
import org.learn.axonframework.axonsaga.event.OrderFiledEvent;

import java.io.Serializable;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Getter
@NoArgsConstructor
@Aggregate
public class Order implements Serializable {

    @AggregateIdentifier
    private String orderID;

    @CommandHandler
    public Order(FileOrderCommand command) {
        apply(new OrderFiledEvent(command.getOrderId(), command.getProductName(), command.getDescription()));
    }

    @EventSourcingHandler
    public void on(OrderFiledEvent event) {
        orderID = event.getId();
    }

}
