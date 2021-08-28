package extentions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class MobileActions extends CommonOps {

    @Step("update text element")
    public static void updateText(MobileElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("tap on element")
    public static void tap(int fingers, MobileElement elem, int duration){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        mobileDriver.tap(fingers,elem,duration);
    }

    @Step("swipe")
    public static void swipe(int startX, int startY,int endX, int endY, int duration){
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        mobileDriver.swipe(startX,startY,endX,endY,duration);
    }

    @Step("zoom element")
    public static void swipe(MobileElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        mobileDriver.zoom(elem);
    }

    @Step("pinch element (zoom out)")
    public static void pinch(MobileElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        mobileDriver.pinch(elem);
    }

    @Step("Execute Script")
    public static void executeScript(String script){
        mobileDriver.executeScript(script);
    }
}
