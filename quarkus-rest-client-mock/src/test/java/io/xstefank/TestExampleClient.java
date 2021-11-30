package io.xstefank;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TestExampleClient {

    @InjectMock
    @RestClient
    ExampleClient exampleClient;

    @Test
    public void testExampleClient() {
        Mockito.when(exampleClient.get()).thenReturn("test");

        given()
            .when().get("/ping")
            .then()
            .statusCode(200)
            .body(is("test"));
    }
}
