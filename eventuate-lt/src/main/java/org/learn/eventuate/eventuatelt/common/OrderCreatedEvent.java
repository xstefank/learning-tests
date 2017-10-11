package org.learn.eventuate.eventuatelt.common;

import org.learn.eventuate.eventuatelt.model.OrderInfo;

public class OrderCreatedEvent implements OrderEvent {

    private OrderInfo order;

    private OrderCreatedEvent(){

    }

    public OrderCreatedEvent(OrderInfo order) {
        this.order = order;
    }

    public OrderInfo getOrder() {
        return order;
    }

    public void setOrder(OrderInfo order) {
        this.order = order;
    }
}
