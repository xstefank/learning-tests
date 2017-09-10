package org.learn.axonframework.axonlt.query;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TransactionHistory {

    @Id
    @GeneratedValue
    private Long id;

    private String accountId;

    private String transactionId;

    private int amount;

    public TransactionHistory() {
    }

    public TransactionHistory(String accountId, String transactionId, int amount) {
        this.accountId = accountId;
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public TransactionHistory(String accountId) {
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
