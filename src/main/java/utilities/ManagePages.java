package utilities;

import io.appium.java_client.MobileDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.grafana.AddNewUserPage;
import pageObjects.grafana.EditUsersPage;
import pageObjects.grafana.ServerAdminMainPage;
import pageObjects.grafana.ServerAdminMenuPage;

public class ManagePages extends Base {

    public static void initGrafana(){

        grafanaLogin = PageFactory.initElements(driver,pageObjects.grafana.LoginPage.class);
        grafanaMain = PageFactory.initElements(driver,pageObjects.grafana.MainPage.class);
        grafanaLeftMenu = PageFactory.initElements(driver,pageObjects.grafana.LeftMenuPage.class);
        grafanaServerAdminMenu = PageFactory.initElements(driver, ServerAdminMenuPage.class);
        grafanaServerAdminMain = PageFactory.initElements(driver, ServerAdminMainPage.class);
        grafanaAddNewUserPage = PageFactory.initElements(driver, AddNewUserPage.class);
        grafanaEditUserPage = PageFactory.initElements(driver, EditUsersPage.class);
    }

    public static void initMortgage(){
        mortMainPage = new pageObjects.Mortgage.MainPage(mobileDriver);
    }
}
