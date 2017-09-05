package org.learn.axonframework.axonsaga.command.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CreateInvoiceCommand {

    private String invoiceId;
    private String orderId;
    private String comment;

    public CreateInvoiceCommand(String invoiceId, String orderId, String comment) {
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
