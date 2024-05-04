package io.xstefank;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class HRResourceTest {

    @Test
    public void testDayOfTheProgrammer() {
        given()
          .when().get("/hr/day-of-the-programmer")
          .then()
             .statusCode(204);
    }

}