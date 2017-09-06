package org.learn.axonframework.axonsaga.event;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CompensateShipmentEvent {

    private String shipmentId;
    private String orderId;
    private String cause;

    public CompensateShipmentEvent(String shipmentId, String orderId, String cause) {
        this.shipmentId = shipmentId;
        this.orderId = orderId;
        this.cause = cause;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCause() {
        return cause;
    }
}
