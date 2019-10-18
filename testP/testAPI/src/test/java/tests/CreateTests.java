package tests;

import base.BaseClass;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static base.TestDataVariables.CREATE_RESOURCE;
import static base.TestDataVariables.ENDPOINT;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CreateTests extends BaseClass {

    private final String employeeSchema = "employeeSchema.json";

    @Test
    public void validatePOSTResponseAndSchema() {

        String name = "employeeOne", salary = "1234", age = "33";
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", name);
        requestParams.put("salary", salary);
        requestParams.put("age", age);

        RestAssured.given()
                .baseUri(ENDPOINT)
                .when()
                .log().all()
                .contentType("application/json")
                .accept("application/json")
                .body(requestParams.toJSONString())
                .post(CREATE_RESOURCE)
                .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .body(matchesJsonSchemaInClasspath(employeeSchema))
                .body("name", equalTo(name))
                .body("salary", equalTo(salary))
                .body("age", equalTo(age))
                .body("id", notNullValue());
    }
}
