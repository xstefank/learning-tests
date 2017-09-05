package org.learn.axonframework.axonsaga;

import org.axonframework.common.jpa.ContainerManagedEntityManagerProvider;
import org.axonframework.config.Configuration;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.eventhandling.saga.repository.SagaStore;
import org.axonframework.eventhandling.saga.repository.jpa.JpaSagaStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AxonSagaApplication {

	public static void main(String[] args) {
		Configuration configuration = DefaultConfigurer.defaultConfiguration()
				.registerComponent(SagaStore.class, c -> new JpaSagaStore(new ContainerManagedEntityManagerProvider()))
				.buildConfiguration();

		SpringApplication.run(AxonSagaApplication.class, args);
	}
}
