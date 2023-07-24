package testing.page.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static testing.page.drivers.WebDriversSetup.driver;


public class HitEnterKey implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();

    }

    public static HitEnterKey onScreen(){
        return Instrumented.instanceOf(HitEnterKey.class).withProperties();
    }
}
