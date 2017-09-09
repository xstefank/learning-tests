package org.learn.axonframework.axonlt;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.axonframework.spring.config.EnableAxon;
import org.learn.axonframework.axonlt.coreapi.CreateAccountCommand;
import org.learn.axonframework.axonlt.coreapi.RequestMoneyTransferCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableAxon
@SpringBootApplication
public class AxonLtApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext config = SpringApplication.run(AxonLtApplication.class, args);

		CommandGateway commandGateway = config.getBean(CommandGateway.class);

		commandGateway.send(new CreateAccountCommand("1234", 500), LoggingCallback.INSTANCE);
		commandGateway.send(new CreateAccountCommand("4321", 500), LoggingCallback.INSTANCE);
		commandGateway.send(new RequestMoneyTransferCommand("tf1", "1234", "4321", 100), LoggingCallback.INSTANCE);



	}


	@Bean
	public EventStorageEngine eventStorageEngine() {
		return new InMemoryEventStorageEngine();
	}


//	@Bean
//	public Repository<Account> jpaAccountRepository(EventBus eventBus) {
//		return new GenericJpaRepository<Account>(entityManagerProvider(), Account.class, eventBus);
//	}
//
//	@Bean
//	public EntityManagerProvider entityManagerProvider() {
//		return new ContainerManagedEntityManagerProvider();
//	}
//	@Bean
//	public TransactionManager axonTransactionManager(PlatformTransactionManager transactionManager) {
//		return new SpringTransactionManager(transactionManager);
//	}

}
