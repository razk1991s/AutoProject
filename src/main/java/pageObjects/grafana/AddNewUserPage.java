package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddNewUserPage {
    @FindBy(how = How.XPATH, using = "//input[@ng-model=\"user.name\"]")
    public WebElement txt_name;

    @FindBy(how = How.XPATH, using = "//input[@ng-model=\"user.email\"]")
    public WebElement txt_email;

    @FindBy(how = How.XPATH, using = "//input[@ng-model=\"user.login\"]")
    public WebElement txt_username;

    @FindBy(how = How.XPATH, using = "//input[@ng-model=\"user.password\"]")
    public WebElement txt_password;

    @FindBy(how = How.XPATH, using = "//button[@class=\"btn btn-primary\"]")
    public WebElement btn_create;
}
