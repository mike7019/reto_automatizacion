package testing.sqa.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static testing.sqa.userinterface.NewMeetingPage.*;

public class ChooseReporter implements Interaction {

    private final int index;

    public ChooseReporter(int index) {
        this.index = index;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement listOrganizedBy = LST_REPORTER.resolveFor(actor);
        List<WebElement> options = listOrganizedBy.findElements(By.tagName("li"));
        options.get(index).click();

    }

    public static ChooseReporter index(int index) {
        return Instrumented.instanceOf(ChooseReporter.class).withProperties(index);
    }
}
