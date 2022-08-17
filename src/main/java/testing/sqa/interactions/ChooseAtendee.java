package testing.sqa.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static testing.sqa.userinterface.NewMeetingPage.*;


public class ChooseAtendee implements Interaction {

    private final int index;

    public ChooseAtendee(int index) {
        this.index = index;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement listLocation = LST_ATENDEE_LIST.resolveFor(actor);
        List<WebElement> options = listLocation.findElements(By.tagName("li"));
        options.get(index).click();
    }

    public static ChooseAtendee index(int index) {
        return Instrumented.instanceOf(ChooseAtendee.class).withProperties(index);
    }
}
