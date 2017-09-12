package org.learn.axonframework.shipmentservice.model;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.junit.Before;
import org.junit.Test;
import org.learn.axonframework.coreapi.PrepareShipmentCommand;

public class ShipmentTest {

    private AggregateTestFixture<Shipment> fixture;

    @Before
    public void setUp() {
        fixture = new AggregateTestFixture<>(Shipment.class);
    }

    @Test
    public void testShipmentCreated() throws Exception {
        fixture.givenNoPriorActivity()
                .when(new PrepareShipmentCommand("1234", "testProduct"))
                .expectSuccessfulHandlerExecution();
    }
}