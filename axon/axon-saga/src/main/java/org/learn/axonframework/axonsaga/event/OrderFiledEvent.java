package org.learn.axonframework.axonsaga.event;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class OrderFiledEvent {

    private String id;
    private String productName;
    private String description;

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
