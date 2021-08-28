package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ServerAdminMainPage {
    @FindBy(how = How.XPATH, using = "//tr[@ng-repeat ='user in ctrl.users']")
    public List <WebElement> rows;

    @FindBy(how = How.XPATH, using = "//a[@class=\"btn btn-primary\"]")
    public WebElement btn_new_user;

    @FindBy(how = How.CSS, using = "input[placeholder='Find user by name/login/email']")
    public WebElement txt_search;
}
