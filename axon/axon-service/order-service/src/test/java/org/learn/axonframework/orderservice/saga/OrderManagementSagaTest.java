package org.learn.axonframework.orderservice.saga;

import org.axonframework.test.saga.SagaTestFixture;
import org.junit.Before;
import org.junit.Test;
import org.learn.axonframework.coreapi.CreateInvoiceCommand;
import org.learn.axonframework.coreapi.OrderFiledEvent;
import org.learn.axonframework.coreapi.PrepareShipmentCommand;

public class OrderManagementSagaTest {

    private static final String ACCOUNT1_ID = "1234";
    private static final String ACCOUNT1_PRODUCT_NAME = "testProduct";
    private static final String ACCOUNT_1_COMMENT = "testComment";
    private static final int ACCOUNT_1_PRICE = 100;

    private SagaTestFixture<OrderManagementSaga> fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new SagaTestFixture<>(OrderManagementSaga.class);
    }

    @Test
    public void testSagaCreated() {
        fixture.givenNoPriorActivity()
                .whenPublishingA(new OrderFiledEvent(ACCOUNT1_ID, ACCOUNT1_PRODUCT_NAME, ACCOUNT_1_COMMENT, ACCOUNT_1_PRICE))
                .expectActiveSagas(1)
                .expectDispatchedCommands(new PrepareShipmentCommand(ACCOUNT1_ID, ACCOUNT1_PRODUCT_NAME, ACCOUNT_1_PRICE),
                        new CreateInvoiceCommand(ACCOUNT1_ID, ACCOUNT1_PRODUCT_NAME, ACCOUNT_1_COMMENT));
    }

}