package testing.sqa.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


import static testing.sqa.userinterface.NewMeetingPage.LST_UNIT;

public class ChooseUnit implements Interaction{

    private final int index;

    public ChooseUnit(int index) {
        this.index = index;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement listOrganizedBy = LST_UNIT.resolveFor(actor);
        List<WebElement> options = listOrganizedBy.findElements(By.tagName("li"));
        options.get(index).click();

    }

    public static ChooseUnit index(int index){
        return Instrumented.instanceOf(ChooseUnit.class).withProperties(index);
    }
}
