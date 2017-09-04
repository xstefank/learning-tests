package org.learn.axonframework.axonsaga.domain;

import org.axonframework.eventhandling.EventHandler;
import org.learn.axonframework.axonsaga.domain.query.OrderQueryObject;
import org.learn.axonframework.axonsaga.event.OrderFiledEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderCommandHandler {

    @Autowired
    private OrderQueryObjectRepository repository;

    @EventHandler
    public void on(OrderFiledEvent event) {
        repository.save(new OrderQueryObject(event.getId(), event.getProductName(), event.getDescription()));
    }
}
