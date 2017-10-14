package org.learn.eventuate.eventuatelt.web;

import org.learn.eventuate.eventuatelt.backend.Order;
import org.learn.eventuate.eventuatelt.model.ResourceWithUrl;
import org.learn.eventuate.eventuatelt.query.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/orders")
public class OrderViewController {

    @Autowired
    private OrderQueryService orderQueryService;

    @RequestMapping(method = GET)
    public HttpEntity<Collection<ResourceWithUrl>> getAllOrders() {
        List<ResourceWithUrl> resourceWithUrls = orderQueryService.getAll().stream().map(this::toResource).collect(Collectors.toList());
        return new ResponseEntity<>(resourceWithUrls, HttpStatus.OK);
    }

    @RequestMapping(value = "/{order-id}", method = GET)
    public CompletableFuture<ResourceWithUrl> getOrder(@PathVariable("order-id") String id) {
        return orderQueryService.findById(id).thenApply(this::toResource);
    }



    protected ResourceWithUrl toResource(Order order) {
        ResourceWithUrl<Order> result = new ResourceWithUrl<>(order);
        if (order != null) {
            result.setUrl(linkTo(methodOn(OrderViewController.class).getOrder(order.getId())).withSelfRel().getHref());
        }
        return result;
    }
}
