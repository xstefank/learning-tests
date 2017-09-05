package org.learn.axonframework.axonsaga.command.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PrepareShippingCommand {

    private String shippingId;
    private String orderId;
    private double shipingPrice;

    public PrepareShippingCommand(String shippingId, String orderId, double shipingPrice) {
        this.shippingId = shippingId;
        this.orderId = orderId;
        this.shipingPrice = shipingPrice;
    }

    public String getShippingId() {
        return shippingId;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getShipingPrice() {
        return shipingPrice;
    }
}
