package org.learn.axonframework.axonlt.coreapi

import org.axonframework.commandhandling.TargetAggregateIdentifier

class RequestMoneyTransferCommand(@TargetAggregateIdentifier val transferId: String,
                                  val sourceAccount: String, val targetAccount: String, val amount: Int)

class MoneyTransferRequestedEvent(val transferId: String, val sourceAccount: String,
                                  val targetAccount: String, val amount: Int)

class CompleteMoneyTransferCommand(@TargetAggregateIdentifier val transferId: String)
class CancelMoneyTransferCommand(@TargetAggregateIdentifier val transferId: String)

class MoneyTransferCompletedEvent(val transferId: String)
class MoneyTransferCancelledEvent(val transferId: String)