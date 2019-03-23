package org.acme.quickstart;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class MockServiceTest {

    @Test
    public void testMockService() {
        RestAssured.when().get("/hello/service").then().body(Matchers.is("mock"));
    }
}
