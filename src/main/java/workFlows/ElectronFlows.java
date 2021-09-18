package workFlows;

import extentions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("add new task to the list")
    public static void addNewTask(String taskName) {
        UIActions.updateText(todoMain.txt_create, taskName);
        UIActions.insertKey(todoMain.txt_create, Keys.RETURN);
    }

    @Step("count and return number of tasks in list")
    public static int getNumberOfTasks() {
        return todoMain.list_task.size();
    }

    @Step("empty lists from tasks")
    public static void emptyLists() {
        for(int i=0; i<getNumberOfTasks(); i++){
            UIActions.mouseHover(todoMain.btn_X);
        }

    }
}
