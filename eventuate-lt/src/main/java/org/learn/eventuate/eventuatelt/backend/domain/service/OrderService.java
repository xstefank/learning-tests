package org.learn.eventuate.eventuatelt.backend.domain.service;

import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;
import org.learn.eventuate.eventuatelt.backend.command.FileOrderCommand;
import org.learn.eventuate.eventuatelt.backend.command.OrderCommand;
import org.learn.eventuate.eventuatelt.backend.domain.OrderAggregate;
import org.learn.eventuate.eventuatelt.model.OrderInfo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class OrderService {

    @Autowired
    private final AggregateRepository<OrderAggregate, OrderCommand> aggregateRepository;

    public OrderService(AggregateRepository<OrderAggregate, OrderCommand> aggregateRepository) {
        this.aggregateRepository = aggregateRepository;
    }

    public CompletableFuture<EntityWithIdAndVersion<OrderAggregate>> save(OrderInfo order) {
        LoggerFactory.getLogger(OrderService.class).info("send FileOrderCommand");
        return aggregateRepository.save(new FileOrderCommand(order));
    }
}
