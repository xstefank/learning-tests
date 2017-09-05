package org.learn.axonframework.axonsaga.event;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderFiledEvent {

    private String orderId;
    private String productName;
    private String description;

    public OrderFiledEvent(String orderId, String productName, String description) {
        this.orderId = orderId;
        this.productName = productName;
        this.description = description;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }
}
