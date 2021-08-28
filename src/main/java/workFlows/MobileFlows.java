package workFlows;

import extentions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("business flow: fill form calculate mortgage")
    public static void calculateMortgage(String amount, String tern, String rate){
        MobileActions.updateText(mortMainPage.txt_amount, amount);
        MobileActions.updateText(mortMainPage.txt_tern, tern);
        MobileActions.updateText(mortMainPage.txt_rate, rate);
        MobileActions.tap(1, mortMainPage.btn_calculate,500);
    }
}
