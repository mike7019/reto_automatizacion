package testing.sqa.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static testing.sqa.userinterface.NewMeetingPage.LST_MEETING_TYPE;

public class ChooseMeetingType implements Interaction {

    private final int index;

    public ChooseMeetingType(int index) {
        this.index = index;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement listMeetingType = LST_MEETING_TYPE.resolveFor(actor);
        List<WebElement> options = listMeetingType.findElements(By.tagName("li"));
        options.get(index).click();

    }

    public static ChooseMeetingType index(int index) {
        return Instrumented.instanceOf(ChooseMeetingType.class).withProperties(index);
    }
}
