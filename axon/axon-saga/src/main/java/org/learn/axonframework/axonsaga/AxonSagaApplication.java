package org.learn.axonframework.axonsaga;

import org.axonframework.common.jpa.ContainerManagedEntityManagerProvider;
import org.axonframework.common.transaction.NoTransactionManager;
import org.axonframework.config.Configuration;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.config.EventHandlingConfiguration;
import org.axonframework.eventhandling.TrackingEventProcessor;
import org.axonframework.eventhandling.saga.repository.SagaStore;
import org.axonframework.eventhandling.saga.repository.jpa.JpaSagaStore;
import org.axonframework.eventhandling.tokenstore.TokenStore;
import org.axonframework.eventhandling.tokenstore.jpa.JpaTokenStore;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.eventsourcing.eventstore.jpa.JpaEventStorageEngine;
import org.learn.axonframework.axonsaga.domain.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AxonSagaApplication {

	public static void main(String[] args) {
		Configuration configuration = DefaultConfigurer.defaultConfiguration()
				.registerComponent(SagaStore.class, c -> new JpaSagaStore(new ContainerManagedEntityManagerProvider()))
				.registerComponent(TokenStore.class, c -> new JpaTokenStore(
						new ContainerManagedEntityManagerProvider(), c.serializer()))
				.buildConfiguration();


		configuration.start();

		SpringApplication.run(AxonSagaApplication.class, args);
	}

	@Bean
	public EventSourcingRepository eventSourcingRepository() {
		EventStorageEngine eventStorageEngine = new JpaEventStorageEngine(new ContainerManagedEntityManagerProvider(), NoTransactionManager.INSTANCE);
		EventStore eventStore = new EmbeddedEventStore(eventStorageEngine);
		EventSourcingRepository repository = new EventSourcingRepository(Shipment.class, eventStore);
		return repository;
	}

	@Autowired
	public void configure(EventHandlingConfiguration config, EventStore eventStore) {
		config.usingTrackingProcessors();
		config.registerTrackingProcessor("MyTrackingProcessor");
	}

}
