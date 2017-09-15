package org.learn.axonframework.orderservice.saga;

import org.learn.axonframework.coreapi.ProductInfo;

public class RequestShipmentCommand {


    private final String orderId;
    private final ProductInfo productInfo;

    public RequestShipmentCommand(String orderId, ProductInfo productInfo) {
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
