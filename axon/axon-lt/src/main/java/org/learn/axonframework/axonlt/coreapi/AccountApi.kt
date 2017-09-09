package org.learn.axonframework.axonlt.coreapi

import org.axonframework.commandhandling.TargetAggregateIdentifier
import java.lang.Exception

class CreateAccountCommand(val accountId : String, val overdraftLimit : Int)
class WithdrawMoneyCommand(@TargetAggregateIdentifier val accountId: String, val transactionId : String, val amount : Int)
class DepositMoneyCommand(@TargetAggregateIdentifier val accountId: String, val transactionId : String, val amount: Int)

class AccountCreatedEvent(val accountId: String, val overdraftLimit: Int)

abstract class BalanceUpdatedEvent(val accountId: String, val balance: Int)
class MoneyWithdrawnEvent(accountId: String, val transactionId : String, val amount: Int, balance: Int) : BalanceUpdatedEvent(accountId, balance)
class MoneyDepositedEvent(accountId: String, val transactionId : String, val amount: Int, balance: Int) : BalanceUpdatedEvent(accountId, balance)

class OverdraftLimitExceededException() : Exception()
