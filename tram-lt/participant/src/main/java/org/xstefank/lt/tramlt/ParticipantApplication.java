package org.xstefank.lt.tramlt;

import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;
import io.eventuate.tram.commands.common.ChannelMapping;
import io.eventuate.tram.commands.common.DefaultChannelMapping;
import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.commands.producer.TramCommandProducerConfiguration;
import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.sagas.orchestration.Saga;
import io.eventuate.tram.sagas.orchestration.SagaManager;
import io.eventuate.tram.sagas.orchestration.SagaManagerImpl;
import io.eventuate.tram.sagas.orchestration.SagaOrchestratorConfiguration;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaParticipantConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.xstefank.lt.tramlt.handler.Handler1;
import org.xstefank.lt.tramlt.handler.HandlerParticipant;
import org.xstefank.lt.tramlt.saga.TestSagaData;

@EnableAutoConfiguration
@Import({TramEventsPublisherConfiguration.class,
		TramCommandProducerConfiguration.class,
		SagaOrchestratorConfiguration.class,
		TramJdbcKafkaConfiguration.class,
		SagaParticipantConfiguration.class})
@SpringBootApplication
public class ParticipantApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParticipantApplication.class, args);
	}

	@Bean
	public SagaManager<TestSagaData> testSagaDataSagaManager(Saga<TestSagaData> saga) {
		return new SagaManagerImpl<>(saga);
	}

	@Bean
	public CommandDispatcher testCommandDispatcher(HandlerParticipant handlerParticipant) {
		return new SagaCommandDispatcher("testCommandDispatcher", handlerParticipant.commandHandlers());
	}

	@Bean
	public ChannelMapping channelMapping() {
		return DefaultChannelMapping.builder().build();
	}
}
