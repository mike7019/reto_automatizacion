package testing.sqa.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class GoToPreviousPage implements Interaction {


    WebDriver driver;

    public static GoToPreviousPage onThePage() {

        return Tasks.instrumented(GoToPreviousPage.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        BrowseTheWeb.as(actor).getDriver().navigate().back();

    }

//    public static GoToPreviousPage onThePage(){
//
//        return Instrumented.instanceOf(GoToPreviousPage.class).withProperties();
//
//    }
}
