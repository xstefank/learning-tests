package org.learn.eventuate.eventuatelt.query;

import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import org.learn.eventuate.eventuatelt.backend.Order;
import org.learn.eventuate.eventuatelt.common.OrderCreatedEvent;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EventSubscriber(id = "orderQueryEventProccessing")
public class OrderQueryEventsubscriber {

    @Autowired
    private OrderQueryService orderQueryService;

    @EventHandlerMethod
    public void handle(DispatchedEvent<OrderCreatedEvent> dispatchedEvent) {
        LoggerFactory.getLogger(OrderQueryEventsubscriber.class).info("on OrderCreatedEvent");
        Order order = new Order(dispatchedEvent.getEvent().getOrder());
        order.setId(dispatchedEvent.getEntityId());

        orderQueryService.save(order);
    }
}
