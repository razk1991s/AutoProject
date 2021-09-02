package sanity;

import extentions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.APIFlows;

public class GrafanaAPI extends CommonOps {

    @Test(description = "test 01 get team from grafana")
    @Description("this test verify team property")
    public void test_01_verify_team(){
        Verifications.verifyText(APIFlows.getTeamProperty("teams[0].name"),"raz");
    }

    @Test(description = "test 02 add team and verify")
    @Description("this test add team to grafana and verify it")
    public void test_02_add_team_and_verify(){
        APIFlows.postTeam("razteam","raz@team.com");
        Verifications.verifyText(APIFlows.getTeamProperty("teams[1].name"),"razteam");
    }

    @Test(description = "test 03 update team and verify")
    @Description("this test update team in grafana and verify it")
    public void test_03_update_team_and_verify(){
        String id = APIFlows.getTeamProperty("teams[1].id");
        APIFlows.updateTeam("razteam","raz@somthing.com",id);
        Verifications.verifyText(APIFlows.getTeamProperty("teams[1].email"),"raz@somthing.com");
    }

    @Test(description = "test 04 delete team and verify")
    @Description("this test delete team to grafana and verify it")
    public void test_04_delete_team_and_verify(){
        String id = APIFlows.getTeamProperty("teams[1].id");
        APIFlows.deleteTeam(id);
        Verifications.verifyText(APIFlows.getTeamProperty("totalCount"),"1");
    }
}
