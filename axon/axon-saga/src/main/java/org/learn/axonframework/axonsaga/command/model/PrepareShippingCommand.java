package org.learn.axonframework.axonsaga.command.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PrepareShippingCommand {

    private String shippingId;
    private String orderId;
    private String productName;
    private double shipingPrice;

    public PrepareShippingCommand(String shippingId, String orderId, String productName, double shipingPrice) {
        this.shippingId = shippingId;
        this.orderId = orderId;
        this.productName = productName;
        this.shipingPrice = shipingPrice;
    }

    public String getShippingId() {
        return shippingId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public double getShipingPrice() {
        return shipingPrice;
    }
}
