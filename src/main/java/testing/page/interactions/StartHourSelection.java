package testing.page.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

public class StartHourSelection implements Interaction {

    private Target element;

    public StartHourSelection(Target element) {
        this.element = element;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElementFacade startHour = element.resolveFor(actor);
        startHour.selectByIndex(4);

    }

    public static StartHourSelection on(Target element){
        return Instrumented.instanceOf(StartHourSelection.class).withProperties(element);
    }
}
