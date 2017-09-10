package org.learn.axonframework.axonlt.query;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.learn.axonframework.axonlt.coreapi.MoneyDepositedEvent;
import org.learn.axonframework.axonlt.coreapi.MoneyWithdrawnEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ProcessingGroup("TransactionHistory")
@RestController
public class TransactionHistoryEventHandler {

    @Autowired
    private TransactionHistoryRepository repository;

    @EventHandler
    private void on(MoneyDepositedEvent event) {
        repository.save(new TransactionHistory(event.getAccountId(), event.getTransactionId(), event.getAmount()));
    }

    @EventHandler
    public void on(MoneyWithdrawnEvent event) {
        repository.save(new TransactionHistory(event.getAccountId(), event.getTransactionId(), -event.getAmount()));
    }

    @GetMapping("/history/{accountId}")
    public List<TransactionHistory> findTransactions(@PathVariable String accountId) {
        return repository.findAll();
    }
}
