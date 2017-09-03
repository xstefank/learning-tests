package org.learn.axonframework.axonsaga.api;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.learn.axonframework.axonsaga.command.FileOrderCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
public class OrderAPI {

    private final CommandGateway commandGateway;

    public OrderAPI(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public CompletableFuture<String> fileOrder(@RequestBody Map<String, String> request) {
        String id = UUID.randomUUID().toString();
        return commandGateway.send(new FileOrderCommand(id, request.get("productName"), request.get("description")));
    }

    @GetMapping
    public List<String> findAllOrders() {
        //TODO remove stub
        return Arrays.asList("order1", "order2");
    }
}
