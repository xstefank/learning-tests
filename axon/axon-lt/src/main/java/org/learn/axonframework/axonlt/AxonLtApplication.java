package org.learn.axonframework.axonlt;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.common.jpa.ContainerManagedEntityManagerProvider;
import org.axonframework.common.jpa.EntityManagerProvider;
import org.axonframework.config.EventHandlingConfiguration;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.axonframework.eventsourcing.eventstore.jpa.JpaEventStorageEngine;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.xml.XStreamSerializer;
import org.axonframework.spring.config.EnableAxon;
import org.axonframework.spring.messaging.unitofwork.SpringTransactionManager;
import org.learn.axonframework.axonlt.coreapi.CreateAccountCommand;
import org.learn.axonframework.axonlt.coreapi.RequestMoneyTransferCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class AxonLtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxonLtApplication.class, args);
	}

	@Autowired
	public void configure(EventHandlingConfiguration configuration) {
		configuration.registerTrackingProcessor("TransactionHistory");
	}

	//should be now default


//	@Bean
//	public EventStorageEngine eventStorageEngine(EntityManagerProvider entityManagerProvider, SpringTransactionManager springTransactionManager) {
//		return new JpaEventStorageEngine(entityManagerProvider, springTransactionManager);
//	}

//	@Bean
//	public SpringTransactionManager springTransactionManager(PlatformTransactionManager platformTransactionManager) {
//		return new SpringTransactionManager(platformTransactionManager);
//	}

//	@Bean
//	public EntityManagerProvider entityManagerProvider() {
//		return new ContainerManagedEntityManagerProvider();
//	}


//	@Bean
//	public Serializer serializer() {
//		return new XStreamSerializer();
//	}

//	@Bean
//	public Repository<Account> jpaAccountRepository(EventBus eventBus) {
//		return new GenericJpaRepository<Account>(entityManagerProvider(), Account.class, eventBus);
//	}
//
//
//	@Bean
//	public TransactionManager axonTransactionManager(PlatformTransactionManager transactionManager) {
//		return new SpringTransactionManager(transactionManager);
//	}

}
