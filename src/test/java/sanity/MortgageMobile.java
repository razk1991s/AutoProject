package sanity;

import extentions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.MobileFlows;
import workFlows.WebFlows;

@Listeners(utilities.Listeners.class)
public class MortgageMobile extends CommonOps {

    @Test(description = "test 01 verify Mortgage")
    @Description("this text fill in mortgage field and calculate repayment")
    public void test01_verifyMortgage(){
        MobileFlows.calculateMortgage("1000","20","3");
        Verifications.verifyTextInElement(mortMainPage.txt_repayment,"£5.60");
    }
}
