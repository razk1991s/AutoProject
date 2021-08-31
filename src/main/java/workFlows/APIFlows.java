package workFlows;

import extentions.APIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class APIFlows extends CommonOps {

    @Step("Business Flow: get team property")
    public static String getTeamProperty (String jPath){
        response = APIActions.get("/api/teams/search");
        return APIActions.extractFromJSON(response, jPath);
    }
}
