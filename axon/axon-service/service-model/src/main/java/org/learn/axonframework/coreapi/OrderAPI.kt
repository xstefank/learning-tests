package org.learn.axonframework.coreapi

import org.axonframework.commandhandling.TargetAggregateIdentifier

class FileOrderCommand(@TargetAggregateIdentifier val orderId: String, val productId: String, val comment: String, val price: Int)
class PrepareShipmentCommand(val orderId: String, val productId: String)
class CreateInvoiceCommand(val orderId: String, val productId: String, val comment: String)


class OrderFiledEvent(val orderId: String, val productId: String, val comment: String, val price: Int)
class ShipmentPreparedEvent(val shipmentId : String, val orderId: String, val shippingPrice : Int)
class InvoiceCreatedEvent(val invoiceId : String, val orderId: String)
