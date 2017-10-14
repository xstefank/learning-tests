package org.learn.eventuate.eventuatelt;

import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import org.learn.eventuate.eventuatelt.backend.command.OrderCommand;
import org.learn.eventuate.eventuatelt.backend.domain.OrderAggregate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(EventuateDriverConfiguration.class)
@EnableAutoConfiguration
@EnableEventHandlers
public class EventuateLtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventuateLtApplication.class, args);
	}

	@Bean
	public AggregateRepository<OrderAggregate, OrderCommand> orderAggregateRepository(EventuateAggregateStore eventStore) {
		return new AggregateRepository<>(OrderAggregate.class, eventStore);
	}

}
