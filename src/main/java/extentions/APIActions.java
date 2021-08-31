package extentions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
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

}
