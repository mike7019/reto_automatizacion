package testing.sqa.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static testing.sqa.userinterface.NewMeetingPage.TXT_START_HOUR;

public class StartHourSelection implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElementFacade startHour = TXT_START_HOUR.resolveFor(actor);
        startHour.selectByIndex(4);

    }

    public static StartHourSelection on(){
        return Instrumented.instanceOf(StartHourSelection.class).withProperties();
    }
}
