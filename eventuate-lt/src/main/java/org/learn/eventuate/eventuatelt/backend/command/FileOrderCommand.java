package org.learn.eventuate.eventuatelt.backend.command;

import org.learn.eventuate.eventuatelt.model.OrderInfo;

public class FileOrderCommand extends OrderCommand {

    private OrderInfo order;

    public FileOrderCommand(OrderInfo order) {
        this.order = order;
    }

    public OrderInfo getOrder() {
        return order;
    }
}
