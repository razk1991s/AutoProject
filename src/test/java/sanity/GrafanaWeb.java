package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extentions.UIActions;
import extentions.Verifications;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.WebFlows;

import javax.xml.transform.sax.SAXResult;


@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {
    @Test(description = "test 01 verify Header")
    @Description("this test login verify the header")
    public void test01_verifyHeader(){
        WebFlows.login(getData("UserName"),getData("Password"));
        Verifications.verifyTextInElement(grafanaMain.Head_Dashboard,"Home Dashboard");
    }

    @Test(description = "test 02 verify default users")
    @Description("this test verify default users")
    public void test02_verify_default_users(){
        UIActions.mouseHover(grafanaLeftMenu.btn_server_admin, grafanaServerAdminMenu.link_users);
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 1);
    }

    @Test(description = "test 03 verify new user")
    @Description("this test verify new user")
    public void test03_verify_new_user(){
        UIActions.mouseHover(grafanaLeftMenu.btn_server_admin, grafanaServerAdminMenu.link_users);
        WebFlows.createNewUser("Raz","raz@gmail.com","darkraz","12345");
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 2);
    }

    @Test(description = "test 04 verify deleted user")
    @Description("this test verify deleted user")
    public void test04_verify_deleted_user(){
        UIActions.mouseHover(grafanaLeftMenu.btn_server_admin, grafanaServerAdminMenu.link_users);
        WebFlows.deleteLastUser();
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 1);
    }

    @Test(description = "test 05 verify progress steps")
    @Description("this test verify progress steps are displayed")
    public void test05_verify_progress_steps(){
        Verifications.visibilityOfElements(grafanaMain.list_progress_steps);
    }

    @Test(description = "test 06 verify avatar icon")
    @Description("this test verify the avatar image using sikuli tool")
    public void test06_verify_avatar_icon(){
        Verifications.visualElement("grafanaAvatar");
    }

    @Test(description = "test 07 search users", dataProvider = "data-provider-users", dataProviderClass = utilities.ManageDDT.class)
    @Description("this test search users using DDT")
    public void test07_search_users(String user, String shouldExist){
        UIActions.mouseHover(grafanaLeftMenu.btn_server_admin, grafanaServerAdminMenu.link_users);
        WebFlows.searchAndVerifyUser(user,shouldExist);
    }


}
