package org.learn.eventuate.eventuatelt.query;

import io.eventuate.CompletableFutureUtil;
import org.learn.eventuate.eventuatelt.backend.Order;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;

@Component
public class OrderQueryService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order) {
        LoggerFactory.getLogger(OrderQueryService.class).info("on save order");
        return orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public CompletableFuture<Order> findById(String id) {
        Order result = orderRepository.findOne(id);
        if (result != null) {
            return CompletableFuture.completedFuture(result);
        }

        return CompletableFutureUtil.failedFuture(new NoSuchElementException("No order wth given id found"));
    }
}
