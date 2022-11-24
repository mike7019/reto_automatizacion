package testing.sqa.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Interact implements Interaction {



    @Override
    public <T extends Actor> void performAs(T t) {

    }

    public static Interact on(){
        return Tasks.instrumented(Interact.class);
    }
}
