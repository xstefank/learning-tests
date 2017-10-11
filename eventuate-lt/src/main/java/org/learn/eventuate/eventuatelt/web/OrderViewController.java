package org.learn.eventuate.eventuatelt.web;

import com.google.common.collect.Lists;
import org.learn.eventuate.eventuatelt.backend.Order;
import org.learn.eventuate.eventuatelt.model.ResourceWithUrl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/orders")
public class OrderViewController {

    @RequestMapping(value = "/{order-id}", method = GET)
    public CompletableFuture<ResourceWithUrl> getOrder(@PathVariable("order-id") String id) {
        //TODO implement query order service
        return new CompletableFuture<>().supplyAsync(() -> toResource(new Order("random-uuid", Collections.singletonList("testProduct"), 20)));
    }

    protected ResourceWithUrl toResource(Order order) {
        ResourceWithUrl<Order> result = new ResourceWithUrl<>(order);
        if (order != null) {
            result.setUrl(linkTo(methodOn(OrderViewController.class).getOrder(order.getId())).withSelfRel().getHref());
        }
        return result;
    }
}
