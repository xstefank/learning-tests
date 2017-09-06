package org.learn.axonframework.axonsaga.event;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CompensateOrderSagaEvent {

    private String orderId;
    private String cause;

    public CompensateOrderSagaEvent(String orderId, String cause) {
        this.orderId = orderId;
        this.cause = cause;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCause() {
        return cause;
    }
}
