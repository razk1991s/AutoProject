package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditUsersPage {
    @FindBy(how = How.XPATH, using = "//button[@ng-click=\"deleteUser(user)\"]")
    public WebElement btn_delete_user;

    @FindBy(how = How.XPATH, using = "//button[@ng-show=\"onConfirm\"]")
    public WebElement btn_confirm_delete_user;
}
