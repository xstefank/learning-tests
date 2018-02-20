package org.xstefank.lt.tramlt.handler;

import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.xstefank.lt.tramlt.command.TestCommand;

import java.util.function.Consumer;

@Component
public class HandlerParticipant {

    private static final Logger log = LoggerFactory.getLogger(HandlerParticipant.class);

    public CommandHandlers commandHandlers() {
        return SagaCommandHandlersBuilder
                .fromChannel("TestChannel")
                .onMessage(TestCommand.class, (Consumer<CommandMessage<TestCommand>>) this::test)
                .build();
    }

    private <C> void test(CommandMessage<C> cCommandMessage) {
        log.info("HandlerParticipant - testCommand received");
    }
}
