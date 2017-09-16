package org.learn.axonframework.shipmentservice.model;

import org.axonframework.commandhandling.TargetAggregateIdentifier;
import org.learn.axonframework.coreapi.ProductInfo;

public class PrepareShipmentCommand {

    @TargetAggregateIdentifier
    private final String orderId;
    private final ProductInfo productInfo;

    public PrepareShipmentCommand(String orderId, ProductInfo productInfo) {
        this.orderId = orderId;
        this.productInfo = productInfo;
    }

    public String getOrderId() {
        return orderId;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }
}
