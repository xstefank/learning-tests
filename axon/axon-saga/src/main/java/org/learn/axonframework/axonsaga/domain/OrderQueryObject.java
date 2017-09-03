package org.learn.axonframework.axonsaga.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderQueryObject {

    @Id
    private String id;

    private String productName;

    private String description;

}
