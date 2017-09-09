package org.learn.axonframework.axonlt.transfer;

import org.axonframework.test.saga.SagaTestFixture;
import org.junit.Before;
import org.junit.Test;
import org.learn.axonframework.axonlt.coreapi.CompleteMoneyTransferCommand;
import org.learn.axonframework.axonlt.coreapi.DepositMoneyCommand;
import org.learn.axonframework.axonlt.coreapi.MoneyDepositedEvent;
import org.learn.axonframework.axonlt.coreapi.MoneyTransferCompletedEvent;
import org.learn.axonframework.axonlt.coreapi.MoneyTransferRequestedEvent;
import org.learn.axonframework.axonlt.coreapi.MoneyWithdrawnEvent;
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
                .expectDispatchedCommands(new WithdrawMoneyCommand("acc1", "tf1", 100));
    }

    @Test
    public void testDepositMoneyAfterWithdrawal() throws Exception {
        fixture.givenAPublished(new MoneyTransferRequestedEvent("tf1", "acc1", "acc2", 100))
                .whenPublishingA(new MoneyWithdrawnEvent("acc1", "tf1", 100, 500))
                .expectDispatchedCommands(new DepositMoneyCommand("acc2", "tf1", 100));
    }

    @Test
    public void testTransferCompletedAfterDeposit() throws Exception {
        fixture.givenAPublished(new MoneyTransferRequestedEvent("tf1", "acc1", "acc2", 100))
                .andThenAPublished(new MoneyWithdrawnEvent("acc1", "tf1", 100, 500))
                .whenPublishingA(new MoneyDepositedEvent("acc2", "tf1", 100, 400))
                .expectDispatchedCommands(new CompleteMoneyTransferCommand("tf1"));
    }

    @Test
    public void testSagaEndsAfterTransactionCompleted() throws Exception {
        fixture.givenAPublished(new MoneyTransferRequestedEvent("tf1", "acc1", "acc2", 100))
                .andThenAPublished(new MoneyWithdrawnEvent("acc1", "tf1", 100, 500))
                .andThenAPublished(new MoneyDepositedEvent("acc2", "tf1", 100, 400))
                .whenPublishingA(new MoneyTransferCompletedEvent("tf1"))
                .expectNoDispatchedCommands()
                .expectActiveSagas(0);
    }

}