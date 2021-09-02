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



    @Step("Business Flow: create new team in grafana")
    public static void postTeam (String name, String email){
        params.put("name",name);
        params.put("email",email);
        APIActions.post(params, "/api/teams");
    }

    @Step("Business Flow: update existing team grafana")
    public static void updateTeam (String name, String email, String id){
        params.put("name",name);
        params.put("email",email);
        APIActions.put(params, "/api/teams" + id);
    }

    @Step("Business Flow: delete existing team in grafana")
    public static void deleteTeam (String id){
        APIActions.delete(id);
    }

}
