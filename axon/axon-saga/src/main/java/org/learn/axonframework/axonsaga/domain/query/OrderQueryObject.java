package org.learn.axonframework.axonsaga.domain.query;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class OrderQueryObject {

    @Id
    private String id;

    private String productName;

    private String description;

    public OrderQueryObject(String id, String productName, String description) {
        this.id = id;
        this.productName = productName;
        this.description = description;
    }
}
