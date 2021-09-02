package extentions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class APIActions extends CommonOps {

    @Step("Get data from server")
    public static Response get(String paramsValues){
        response = httpRequest.get(paramsValues);
        response.prettyPrint();
        return response;
    }

    @Step("extract value from JSON format")
    public static String extractFromJSON(Response response, String path){
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("Post Data to Server")
    public static void post(JSONObject params, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        response.prettyPrint();
    }

    @Step("Update Data in Server")
    public static void put(JSONObject params, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        response.prettyPrint();
    }

    @Step("Delete Data from Server")
    public static void delete(String id) {
        response = httpRequest.delete("/api/teams/" + id);
        response.prettyPrint();
    }

}
