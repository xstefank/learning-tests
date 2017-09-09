package org.learn.axonframework.axonlt;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.config.Configuration;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.config.EventHandlingConfiguration;
import org.axonframework.config.SagaConfiguration;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.learn.axonframework.axonlt.account.Account;
import org.learn.axonframework.axonlt.coreapi.CreateAccountCommand;
import org.learn.axonframework.axonlt.coreapi.RequestMoneyTransferCommand;
import org.learn.axonframework.axonlt.transfer.LoggingEventHandler;
import org.learn.axonframework.axonlt.transfer.MoneyTransfer;
import org.learn.axonframework.axonlt.transfer.MoneyTransferSaga;

public class Application {


    public static void main(String[] args) {
        Configuration config = DefaultConfigurer.defaultConfiguration()
                .configureAggregate(Account.class)
                .configureAggregate(MoneyTransfer.class)
                .registerModule(SagaConfiguration.subscribingSagaManager(MoneyTransferSaga.class))
                .registerModule(new EventHandlingConfiguration().registerEventHandler(c -> new LoggingEventHandler()))
                .configureEmbeddedEventStore(c -> new InMemoryEventStorageEngine())
                .buildConfiguration();

        config.start();

        CommandGateway commandGateway = config.commandGateway();

        commandGateway.send(new CreateAccountCommand("1234", 500), LoggingCallback.INSTANCE);
        commandGateway.send(new CreateAccountCommand("4321", 500), LoggingCallback.INSTANCE);
        commandGateway.send(new RequestMoneyTransferCommand("tf1", "1234", "4321", 100), LoggingCallback.INSTANCE);

        config.shutdown();
    }

}
