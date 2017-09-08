package org.learn.axonframework.axonlt.transfer;

import org.axonframework.test.saga.SagaTestFixture;
import org.junit.Before;
import org.junit.Test;
import org.learn.axonframework.axonlt.coreapi.MoneyTransferRequestedEvent;
import org.learn.axonframework.axonlt.coreapi.WithdrawMoneyCommand;

public class MoneyTransferSagaTest {

    private SagaTestFixture fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new SagaTestFixture<>(MoneyTransferSaga.class);
    }

    @Test
    public void testMoneyTransferRequest() throws Exception {
        fixture.givenNoPriorActivity()
                .whenPublishingA(new MoneyTransferRequestedEvent("tf1", "acc1", "acc2", 100))
                .expectActiveSagas(1)
                .expectDispatchedCommands(new WithdrawMoneyCommand("acc1", 100));
    }

}