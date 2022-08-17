package testing.sqa.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static testing.sqa.userinterface.NewMeetingPage.*;

public class ChooseOrganizer implements Interaction {

    private final int index;

    public ChooseOrganizer(int index) {
        this.index = index;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement listOrganizedBy = LST_ORGANIZED_BY.resolveFor(actor);
        List<WebElement> options = listOrganizedBy.findElements(By.tagName("li"));
        options.get(index).click();

    }

    public static ChooseOrganizer index(int index) {
        return Instrumented.instanceOf(ChooseOrganizer.class).withProperties(index);
    }
}
