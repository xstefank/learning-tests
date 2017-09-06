package org.learn.axonframework.axonsaga.command.model;

import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@NoArgsConstructor
public class CompensateShipmentCommand {

    @TargetAggregateIdentifier
    private String shipmentId;
    private String orderId;
    private String cause;

    public CompensateShipmentCommand(String shipmentId, String orderId, String cause) {
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
