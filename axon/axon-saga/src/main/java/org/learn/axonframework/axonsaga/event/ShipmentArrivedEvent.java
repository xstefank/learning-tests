package org.learn.axonframework.axonsaga.event;

public class ShipmentArrivedEvent {

    private String shipmentId;
    private String orderId;
    private double price;

    public ShipmentArrivedEvent() {
    }

    public ShipmentArrivedEvent(String shipmentId, String orderId, double price) {
        this.shipmentId = shipmentId;
        this.orderId = orderId;
        this.price = price;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getPrice() {
        return price;
    }
}
