package testing.sqa.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class CloseCurrentTab implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        BrowseTheWeb.as(actor).getDriver().close();

    }

    public static Performable on(){
        return Instrumented.instanceOf(CloseCurrentTab.class).withProperties();
    }
}
