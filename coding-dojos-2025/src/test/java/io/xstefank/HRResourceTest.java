package io.xstefank;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class HRResourceTest {

    @Test
    public void testBillDivision() {
        given()
          .when().get("/bill-division")
          .then()
             .statusCode(204);
    }

}