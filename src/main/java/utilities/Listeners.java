package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {
    public void onFinish(ITestContext arg0)
    {
        System.out.println("---------Ending Execution--------");
    }

    public void onStart(ITestContext arg0)
    {
        System.out.println("---------Starting Execution--------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
    {
        // TODO Auto-generated method stub
    }

    public void onTestFailure(ITestResult test)
    {
        System.out.println("------------Test: "+test.getName()+" Failed ---------------");
        //make screen shot
        saveScreenShot();
        //stop recording
        try {
            monteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult test)
    {
        System.out.println("------------Skipping Test: "+test.getName()+"---------------");
    }

    public void onTestStart(ITestResult test)
    {
        System.out.println("------------Starting Test: "+test.getName()+"---------------");
    }

    public void onTestSuccess(ITestResult test)
    {
        System.out.println("------------Test: "+test.getName()+" Passed ---------------");
        // stop recording
        try {
            monteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File("./test-recordings/"+test.getName()+ ".avi");
        // delete the file
        if (file.delete())
            System.out.println("file deleted successfully");
        else
            System.out.println("failed to delete file");
    }

    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte [] saveScreenShot(){
        if (!getData("PlatformName").equalsIgnoreCase("mobile"))
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        else
            return ((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.BYTES);

    }
}
