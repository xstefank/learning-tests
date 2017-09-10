package org.learn.axonframework.orderservice.rest;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.learn.axonframework.coreapi.FileOrderCommand;
import org.learn.axonframework.util.LoggingCallback;
import org.learn.axonframework.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String createOrder(@RequestBody Map<String, String> request) {
        String orderId = Util.generateId();
        commandGateway.send(new FileOrderCommand(orderId, request.get("productName"),
                request.get("comment"), Integer.valueOf(request.get("price"))), LoggingCallback.INSTANCE);

        return "Order posted - " + orderId;
    }
}
