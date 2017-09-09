package org.learn.axonframework.axonlt.account;

import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.learn.axonframework.axonlt.coreapi.AccountCreatedEvent;
import org.learn.axonframework.axonlt.coreapi.BalanceUpdatedEvent;
import org.learn.axonframework.axonlt.coreapi.CreateAccountCommand;
import org.learn.axonframework.axonlt.coreapi.DepositMoneyCommand;
import org.learn.axonframework.axonlt.coreapi.MoneyDepositedEvent;
import org.learn.axonframework.axonlt.coreapi.MoneyWithdrawnEvent;
import org.learn.axonframework.axonlt.coreapi.OverdraftLimitExceededException;
import org.learn.axonframework.axonlt.coreapi.WithdrawMoneyCommand;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @AggregateIdentifier
    private String accountId;

    @Basic
    private int balance;

    @Basic
    private int overdraftLimit;

    @CommandHandler
    public Account(CreateAccountCommand command) {
        apply(new AccountCreatedEvent(command.getAccountId(), command.getOverdraftLimit()));
    }

    @CommandHandler
    public void handle(WithdrawMoneyCommand command) throws OverdraftLimitExceededException {
        if (balance + overdraftLimit >= command.getAmount()) {
            apply(new MoneyWithdrawnEvent(accountId, command.getTransactionId(),
                    command.getAmount(), balance - command.getAmount()));
        } else {
            throw new OverdraftLimitExceededException();
        }
    }

    @CommandHandler
    public void handle(DepositMoneyCommand command) {
        apply(new MoneyDepositedEvent(command.getAccountId(), command.getTransactionId(),
                command.getAmount(), balance + command.getAmount()));
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event) {
        accountId = event.getAccountId();
        overdraftLimit = event.getOverdraftLimit();
    }

    @EventSourcingHandler
    public void on(BalanceUpdatedEvent event) {
        balance = event.getBalance();
    }

}
