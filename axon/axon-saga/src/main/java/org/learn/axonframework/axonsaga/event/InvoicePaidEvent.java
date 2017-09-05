package org.learn.axonframework.axonsaga.event;

public class InvoicePaidEvent {

    private String invoiceId;
    private String orderId;
    private String comment;

    public InvoicePaidEvent() {
    }

    public InvoicePaidEvent(String invoiceId, String orderId, String comment) {
        this.invoiceId = invoiceId;
        this.orderId = orderId;
        this.comment = comment;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getComment() {
        return comment;
    }
}
