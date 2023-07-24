package testing.page.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import testing.page.drivers.WebDriversSetup;


public class SelectorJS implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        JavascriptExecutor js = (JavascriptExecutor) WebDriversSetup.driver;
        WebElement button = (WebElement) js.executeScript("document.querySelector('#StartSharp_Membership_LoginPanel0_Username')");
        button.click();


    }

    public static SelectorJS on(){
        return Instrumented.instanceOf(SelectorJS.class).withProperties();
    }
}
