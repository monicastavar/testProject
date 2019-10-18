package tests;

import base.BaseClass;
import base.TestDataVariables;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static base.TestDataVariables.ENDPOINT;
import static base.TestDataVariables.UPDATE_RESOURCE;
import static org.hamcrest.Matchers.equalTo;

public class UpdateTests extends BaseClass {

    @Test
    public void validatePUTResponse () {

        String name = "employeeOne", salary = "1234", age = "33";
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", name);
        requestParams.put("salary", salary);
        requestParams.put("age", age);
        String id = TestDataVariables.getId(0);

        RestAssured.given()
                .baseUri(ENDPOINT)
                .when()
                .log().all()
                .contentType("application/json")
                .accept("application/json")
                .body(requestParams.toJSONString())
                .put(UPDATE_RESOURCE + id)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo(name))
                .body("salary", equalTo(salary))
                .body("age", equalTo(age))
                .body("id", equalTo(id));
    }
}
