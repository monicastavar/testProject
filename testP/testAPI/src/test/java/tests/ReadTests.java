package tests;

import base.BaseClass;
import base.TestDataVariables;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static base.TestDataVariables.*;
import static org.hamcrest.Matchers.equalTo;

public class ReadTests extends BaseClass {


    @Test
    public void validateGETAllResponseCode() {
        RestAssured.given()
                .log().all()
                .baseUri(ENDPOINT)
                .when()
                .get(GET_ALL_RESOURCE)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void validateGETEmployeeResponse() {
        String name = "employeeOne", salary = "1234", age = "33";

        RestAssured.given()
                .log().all()
                .baseUri(ENDPOINT)
                .when()
                .log().all()
                .get(GET_ID_RESOURCE + TestDataVariables.getId(0))
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo(name))
                .body("salary", equalTo(salary))
                .body("age", equalTo(age));
    }
}
