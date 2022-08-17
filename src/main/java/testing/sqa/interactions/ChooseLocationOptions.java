package testing.sqa.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static testing.sqa.userinterface.NewMeetingPage.LST_LOCATION_OPTIONS;

public class ChooseLocationOptions implements Interaction {

    private final int index;

    public ChooseLocationOptions(int index) {
        this.index = index;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement listLocation = LST_LOCATION_OPTIONS.resolveFor(actor);
        List<WebElement> options = listLocation.findElements(By.tagName("li"));
        options.get(index).click();
    }

    public static ChooseLocationOptions index(int index) {
        return Instrumented.instanceOf(ChooseLocationOptions.class).withProperties(index);
    }
}
