package sanity;

import extentions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.WebFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaWebDB  extends CommonOps {
    public class GrafanaWeb extends CommonOps {
        @Test(description = "test 01 Login to Grafana with DB credentials")
        @Description("this test Login to Grafana with DB credentials and verify the header")
        public void test01_login_DB_and_verify_header() {
            WebFlows.loginDB();
            Verifications.verifyTextInElement(grafanaMain.Head_Dashboard, "Home Dashboard");
        }

    }
}
