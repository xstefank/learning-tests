package org.learn.axonframework.axonsaga.command.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CreateInvoiceCommand {

    private String invoiceId;
    private String orderId;
    private String productName;
    private String comment;

    public CreateInvoiceCommand(String invoiceId, String orderId, String productName, String comment) {
        this.invoiceId = invoiceId;
        this.orderId = orderId;
        this.productName = productName;
        this.comment = comment;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public String getComment() {
        return comment;
    }
}
