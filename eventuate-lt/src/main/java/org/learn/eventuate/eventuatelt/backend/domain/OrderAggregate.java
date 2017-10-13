package org.learn.eventuate.eventuatelt.backend.domain;

import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import org.learn.eventuate.eventuatelt.common.OrderCreatedEvent;
import org.learn.eventuate.eventuatelt.model.OrderInfo;
import org.learn.eventuate.eventuatelt.backend.command.FileOrderCommand;
import org.learn.eventuate.eventuatelt.backend.command.OrderCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OrderAggregate extends ReflectiveMutableCommandProcessingAggregate<OrderAggregate, OrderCommand> {

    private static final Logger log = LoggerFactory.getLogger(OrderAggregate.class);

    private OrderInfo order;

    public List<Event> process(FileOrderCommand command) {
        log.info("received FileOrderCommand");
        return EventUtil.events(new OrderCreatedEvent(command.getOrder()));
    }

    public void apply(OrderCreatedEvent event) {
        log.info("on OrderCreatedEvent");
        order = event.getOrder();
    }

    public OrderInfo getOrder() {
        return order;
    }
}
