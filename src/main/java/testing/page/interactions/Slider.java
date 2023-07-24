package testing.page.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static testing.page.drivers.WebDriversSetup.driver;

public class Slider implements Interaction {

    Target element;
    int rank;

    public Slider(Target element, int rank) {
        this.element = element;
        this.rank = rank;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        driver.switchTo().frame(0);
        WebElement slider = element.resolveFor(actor);
        Actions move = new Actions(driver);
        Action action = move.dragAndDropBy(slider, rank, 0).build();
        action.perform();
    }

    public static Slider on(Target element, int rank){
        return Instrumented.instanceOf(Slider.class).withProperties(element, rank);
    }
}
