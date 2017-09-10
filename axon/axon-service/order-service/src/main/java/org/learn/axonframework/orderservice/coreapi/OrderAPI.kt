package org.learn.axonframework.orderservice.coreapi

import org.axonframework.commandhandling.TargetAggregateIdentifier

class FileOrderCommand(@TargetAggregateIdentifier val orderId: String, val productName: String, val comment: String, val price: Int)
class PrepareShipmentCommand(val orderId: String, val productName: String, val price: Int)
class CreateInvoiceCommand(val orderId: String, val productName: String, val comment: String)


class OrderFiledEvent(val orderId: String, val productName: String, val comment: String, val price: Int)
class ShipmentPreparedEvent(val shipmentId : String, val orderId: String)
class InvoiceCreatedEvent(val invoiceId : String, val orderId: String)