package testing.page.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class HitDownKey implements Interaction {

    WebDriver driver;
    @Override
    public <T extends Actor> void performAs(T actor) {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.DOWN).build().perform();

    }

    public static HitDownKey onScreen(){
        return Instrumented.instanceOf(HitDownKey.class).withProperties();
    }
}
