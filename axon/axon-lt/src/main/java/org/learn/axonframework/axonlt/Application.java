package org.learn.axonframework.axonlt;

import org.axonframework.commandhandling.AsynchronousCommandBus;
import org.axonframework.config.Configuration;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.learn.axonframework.axonlt.account.Account;
import org.learn.axonframework.axonlt.coreapi.CreateAccountCommand;
import org.learn.axonframework.axonlt.coreapi.WithdrawMoneyCommand;

import static org.axonframework.commandhandling.GenericCommandMessage.asCommandMessage;

public class Application {

    private static final String ACCOUNT_ID = "4321";
    private static final String TRANSACTION_ID = "tx1";


    public static void main(String[] args) {
        Configuration config = DefaultConfigurer.defaultConfiguration()
                .configureAggregate(Account.class)
                .configureEmbeddedEventStore(c -> new InMemoryEventStorageEngine())
                .configureCommandBus(c -> new AsynchronousCommandBus())
                .buildConfiguration();

        config.start();
        config.commandBus().dispatch(asCommandMessage(new CreateAccountCommand(ACCOUNT_ID, 500)));
        config.commandBus().dispatch(asCommandMessage(new WithdrawMoneyCommand(ACCOUNT_ID, TRANSACTION_ID, 250)));
        config.commandBus().dispatch(asCommandMessage(new WithdrawMoneyCommand(ACCOUNT_ID, TRANSACTION_ID, 251)));
    }

}
