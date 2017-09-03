package org.learn.axonframework.axonsaga.domain;

import lombok.Setter;
import org.axonframework.commandhandling.model.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class OrderCommandHandler {

    @Setter
    @Autowired
    @Qualifier("userRepository")
    private Repository<Order> repository;
}
