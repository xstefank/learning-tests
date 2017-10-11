package org.learn.eventuate.eventuatelt.web;

import org.learn.eventuate.eventuatelt.backend.domain.service.OrderService;
import org.learn.eventuate.eventuatelt.common.controller.BaseController;
import org.learn.eventuate.eventuatelt.model.OrderInfo;
import org.learn.eventuate.eventuatelt.model.ResourceWithUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = POST)
    public CompletableFuture<ResourceWithUrl> saveOrder(@RequestBody OrderInfo order, HttpServletRequest request) {
        Assert.isTrue(order.getProducts().size() >= 1, "Order must contain at least one product");
        return orderService.save(order).thenApply(e -> withRequestAttributeContext(request, () -> toResource(e.getAggregate().getOrder(), e.getEntityId())));
    }

    protected ResourceWithUrl toResource(OrderInfo order, String id) {
        ResourceWithUrl<OrderInfo> result = new ResourceWithUrl<>(order);
        result.setId(id);
        result.setUrl(ControllerLinkBuilder.linkTo(methodOn(OrderViewController.class).getOrder(id)).withSelfRel().getHref());
        return result;
    }
}
