package org.xstefank.lt.tramlt.saga;

import io.eventuate.tram.commands.consumer.CommandWithDestination;
import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.xstefank.lt.tramlt.command.TestCommand;

import static io.eventuate.tram.commands.consumer.CommandWithDestinationBuilder.send;

@Component
public class TestSaga implements SimpleSaga<TestSagaData> {

    private static final Logger log = LoggerFactory.getLogger(TestSaga.class);

    private SagaDefinition<TestSagaData> sagaDefinition =
            step()
                .invokeParticipant(this::testParticipant)
            .build();

    @Override
    public SagaDefinition<TestSagaData> getSagaDefinition() {
        return sagaDefinition;
    }

    private CommandWithDestination testParticipant(TestSagaData testSagaData) {
        log.info("sending command...");

        return send(new TestCommand(testSagaData.getName()))
                .to("TestChannel")
                .build();
    }
}
