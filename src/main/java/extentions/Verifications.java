package extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.AssertJUnit.*;

public class Verifications extends CommonOps {

    @Step("verify text in element")
    public static void verifyTextInElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step("verify number of element")
    public static void numberOfElements(List<WebElement> elems, int expected){
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(), expected);
    }

    @Step("verify visibility of elements")
    public static void visibilityOfElements(List <WebElement> elems){
        for(WebElement elem: elems) {
            softAssert.assertTrue(elem.isDisplayed(), "sorry"+ elem.getText() + "not displayed");
        }
        softAssert.assertAll();
    }

    @Step("verify element visually")
    public static void visualElement(String expectedImageName){
        try {
            screen.find(getData("ImageRepo")+expectedImageName+".PNG");
        } catch (FindFailed findFailed) {
            System.out.println("Error comparing image file: "+findFailed);
            fail("Error comparing image file: "+findFailed);
        }
    }

    @Step("verify element is displayed")
    public static void existenceOfElements(List<WebElement> elements){
        assertTrue(elements.size()>0);
    }

    @Step("verify element is not displayed")
    public static void nontExistenceOfElements(List <WebElement> elements){
        assertFalse(elements.size()>0);
    }
}


