package org.learn.axonframework.axonsaga.event;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CompensateInvoiceEvent {

    private String invoiceId;
    private String orderId;
    private String cause;

    public CompensateInvoiceEvent(String invoiceId, String orderId, String cause) {
        this.invoiceId = invoiceId;
        this.orderId = orderId;
        this.cause = cause;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCause() {
        return cause;
    }

}

