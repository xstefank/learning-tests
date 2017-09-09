package org.learn.axonframework.axonlt;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.model.GenericJpaRepository;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.common.jpa.ContainerManagedEntityManagerProvider;
import org.axonframework.common.jpa.EntityManagerProvider;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.axonframework.spring.config.EnableAxonAutoConfiguration;
import org.axonframework.spring.messaging.unitofwork.SpringTransactionManager;
import org.learn.axonframework.axonlt.account.Account;
import org.learn.axonframework.axonlt.coreapi.CreateAccountCommand;
import org.learn.axonframework.axonlt.coreapi.WithdrawMoneyCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

import static org.axonframework.commandhandling.GenericCommandMessage.asCommandMessage;

@EnableAxonAutoConfiguration
@SpringBootApplication
public class AxonLtApplication {

	private static final String ACCOUNT_ID = "4321";
	private static final String TRANSACTION_ID = "tx1";

	public static void main(String[] args) {
		ConfigurableApplicationContext config = SpringApplication.run(AxonLtApplication.class, args);
		CommandBus commandBus = config.getBean(CommandBus.class);

		commandBus.dispatch(asCommandMessage(new CreateAccountCommand(ACCOUNT_ID, 500)), new CommandCallback<Object, Object>() {
			@Override
			public void onSuccess(CommandMessage<?> commandMessage, Object o) {
				System.out.println("command completed successfully");
				commandBus.dispatch(asCommandMessage(new WithdrawMoneyCommand(ACCOUNT_ID, TRANSACTION_ID, 250)));
				commandBus.dispatch(asCommandMessage(new WithdrawMoneyCommand(ACCOUNT_ID, TRANSACTION_ID,251)));
			}

			@Override
			public void onFailure(CommandMessage<?> commandMessage, Throwable throwable) {
				throwable.printStackTrace();
			}
		});

	}

	@Bean
	public Repository<Account> jpaAccountRepository(EventBus eventBus) {
		return new GenericJpaRepository<Account>(entityManagerProvider(), Account.class, eventBus);
	}

	@Bean
	public EntityManagerProvider entityManagerProvider() {
		return new ContainerManagedEntityManagerProvider();
	}

	@Bean
	public EventStorageEngine eventStorageEngine() {
		return new InMemoryEventStorageEngine();
	}

	@Bean
	public TransactionManager axonTransactionManager(PlatformTransactionManager transactionManager) {
		return new SpringTransactionManager(transactionManager);
	}

}
