package utilities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.grafana.*;
import pageObjects.Mortgage.*;

public class Base {
    //General:
    protected static WebDriverWait wait;
    protected  static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;

    //Web:
    protected static WebDriver driver;

    //Mobile:
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();


    //Page Objects - Web
    protected static pageObjects.grafana.LoginPage grafanaLogin;
    protected static pageObjects.grafana.MainPage grafanaMain;
    protected static pageObjects.grafana.LeftMenuPage grafanaLeftMenu;
    protected static ServerAdminMenuPage grafanaServerAdminMenu;
    protected static ServerAdminMainPage grafanaServerAdminMain;
    protected static AddNewUserPage grafanaAddNewUserPage;
    protected static EditUsersPage grafanaEditUserPage;

    //Page objects - Mobile
    protected static pageObjects.Mortgage.MainPage mortMainPage;

}
