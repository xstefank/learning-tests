package org.learn.eventuate.eventuatelt.backend.domain.service;

import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;
import org.learn.eventuate.eventuatelt.backend.command.FileOrderCommand;
import org.learn.eventuate.eventuatelt.backend.command.OrderCommand;
import org.learn.eventuate.eventuatelt.backend.domain.OrderAggregate;
import org.learn.eventuate.eventuatelt.model.OrderInfo;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class OrderService {


    private final AggregateRepository<OrderAggregate, OrderCommand> aggregateRepository;

    public OrderService(AggregateRepository<OrderAggregate, OrderCommand> aggregateRepository) {
        this.aggregateRepository = aggregateRepository;
    }

    public CompletableFuture<EntityWithIdAndVersion<OrderAggregate>> save(OrderInfo order) {
        //generate id
        order.setId(UUID.randomUUID().toString());

        return aggregateRepository.save(new FileOrderCommand(order));
    }
}
