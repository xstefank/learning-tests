package org.learn.eventuate.eventuatelt;

import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import org.learn.eventuate.eventuatelt.backend.command.OrderCommand;
import org.learn.eventuate.eventuatelt.backend.domain.OrderAggregate;
import org.learn.eventuate.eventuatelt.backend.domain.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(EventuateDriverConfiguration.class)
@EnableAutoConfiguration
@ComponentScan({"org.learn.eventuate.eventuatelt.backend",
		"org.learn.eventuate.eventuatelt.common",
		"org.learn.eventuate.eventuatelt.web"})
@EntityScan("org.learn.eventuate.eventuatelt")
@EnableEventHandlers
public class EventuateLtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventuateLtApplication.class, args);
	}

	@Bean
	public AggregateRepository<OrderAggregate, OrderCommand> orderAggregateRepository(EventuateAggregateStore eventStore) {
		return new AggregateRepository<>(OrderAggregate.class, eventStore);
	}

	@Bean
	public OrderService orderService(AggregateRepository<OrderAggregate, OrderCommand> aggregateRepository) {
		return new OrderService(aggregateRepository);
	}

}
