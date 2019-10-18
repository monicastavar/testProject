package tests;

import base.BaseClass;
import base.TestDataVariables;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static base.TestDataVariables.DELETE_RESOURCE;
import static base.TestDataVariables.ENDPOINT;

public class DeleteTests extends BaseClass {

    @Test
    public void validateDeleteResponseCode() {

        RestAssured.given()
                .log().all()
                .baseUri(ENDPOINT)
                .when()
                .delete(DELETE_RESOURCE + TestDataVariables.getId(0))
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }
}
