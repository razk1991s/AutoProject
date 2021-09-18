package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extentions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.ElectronFlows;
import workFlows.MobileFlows;

import java.util.concurrent.TimeUnit;

public class todoListElectron extends CommonOps {

    @Test(description = "test 01 add and verify new task")
    @Description("this test add and verify new task")
    public void test01_add_and_verify_new_task(){
        ElectronFlows.addNewTask("Learn JAVA");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(),1);
    }

    @Test(description = "test 02 add and verify new tasks")
    @Description("this test add and verify new task")
    public void test02_add_and_verify_new_tasks(){
        ElectronFlows.addNewTask("Learn JAVA");
        ElectronFlows.addNewTask("Learn C#");
        ElectronFlows.addNewTask("Learn Python");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(),3);
    }
}
