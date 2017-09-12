package org.learn.axonframework.orderservice.order;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.junit.Before;
import org.junit.Test;
import org.learn.axonframework.coreapi.FileOrderCommand;
import org.learn.axonframework.coreapi.OrderFiledEvent;

public class OrderTest {

    private static final String ACCOUNT1_ID = "1234";
    private static final String ACCOUNT1_PRODUCT_ID = "testProduct";
    private static final String ACCOUNT_1_COMMENT = "testComment";
    private static final int ACCOUNT_1_PRICE = 100;

    private AggregateTestFixture<Order> fixture;

    @Before
    public void setUp() {
        fixture = new AggregateTestFixture<>(Order.class);
    }

    @Test
    public void testOrderCreatedFiresEvents() {
        fixture.givenNoPriorActivity()
                .when(new FileOrderCommand(ACCOUNT1_ID, ACCOUNT1_PRODUCT_ID, ACCOUNT_1_COMMENT, ACCOUNT_1_PRICE))
                .expectEvents(new OrderFiledEvent(ACCOUNT1_ID, ACCOUNT1_PRODUCT_ID, ACCOUNT_1_COMMENT, ACCOUNT_1_PRICE));
    }

}