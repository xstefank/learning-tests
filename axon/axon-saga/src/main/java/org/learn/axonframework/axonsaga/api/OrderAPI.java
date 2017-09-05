package org.learn.axonframework.axonsaga.api;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.learn.axonframework.axonsaga.command.model.FileOrderCommand;
import org.learn.axonframework.axonsaga.domain.OrderQueryObjectRepository;
import org.learn.axonframework.axonsaga.domain.query.OrderQueryObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
public class OrderAPI {

    private final CommandGateway commandGateway;
    private final OrderQueryObjectRepository repository;

    public OrderAPI(CommandGateway commandGateway, OrderQueryObjectRepository repository) {
        this.commandGateway = commandGateway;
        this.repository = repository;
    }

    @PostMapping
    public CompletableFuture<String> fileOrder(@RequestBody Map<String, String> request) {
        String id = UUID.randomUUID().toString();
        return commandGateway.send(new FileOrderCommand(id, request.get("productName"), request.get("description")));
    }

    @GetMapping
    public List<OrderQueryObject> findAllOrders() {
       return repository.findAll();
    }

    @GetMapping("/{id}")
    public OrderQueryObject findOne(@PathVariable String id) {
        return repository.findOne(id);
    }
}
