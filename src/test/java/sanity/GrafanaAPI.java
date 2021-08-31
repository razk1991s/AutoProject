package sanity;

import extentions.Verifications;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.APIFlows;

public class GrafanaAPI extends CommonOps {

    @Test(description = "test 01 get team from grafana")
    public void test_01_verify_team(){
        Verifications.verifyText(APIFlows.getTeamProperty("teams[0].name"),"yoni");
    }
}
