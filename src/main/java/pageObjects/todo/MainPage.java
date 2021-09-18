package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy(how = How.CSS, using = "input[placeholder = 'Create a task'")
    public WebElement txt_create;

    @FindBy(how = How.CLASS_NAME, using = "view_2Ow90'")
    public List <WebElement> list_task;
}
