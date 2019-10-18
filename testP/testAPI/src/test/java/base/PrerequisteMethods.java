package base;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class PrerequisteMethods {
    FileReader fileReader = new FileReader();
    String endpoint = fileReader.getProperty("endpoint");
    String createResource = fileReader.getProperty("CreateEmployeeResource");
    String deleteResource = fileReader.getProperty("DeleteEmployeeResource");


    public String createEntry() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "test");
        requestParams.put("salary", "test");
        requestParams.put("age", "test");

        String response = given()
                .baseUri(endpoint)
                .when()
                .contentType("application/json")
                .accept("application/json")
                .body(requestParams.toJSONString())
                .post(createResource).asString();

        JsonPath jsonPath = new JsonPath(response);
        return jsonPath.get("id");
    }

    public void deleteEntry(String id) {
        RestAssured.given()
                .baseUri(endpoint)
                .when()
                .delete(deleteResource + id);
    }
}
