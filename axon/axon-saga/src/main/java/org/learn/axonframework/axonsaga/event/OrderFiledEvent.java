package org.learn.axonframework.axonsaga.event;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderFiledEvent {

    private String id;
    private String productName;
    private String description;

    public OrderFiledEvent(String id, String productName, String description) {
        this.id = id;
        this.productName = productName;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }
}
