package testing.sqa.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.Keys;

import static testing.sqa.userinterface.NewMeetingPage.*;

public class SelectMeetingType implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElementFacade object = TXT_MEETING_TYPE.resolveFor(actor);
        object.type("Customer").then().type(Keys.ENTER);

    }

    public static SelectMeetingType onTheField(){
        return Instrumented.instanceOf(SelectMeetingType.class).withProperties();
    }
}
