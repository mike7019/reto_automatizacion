package testing.sqa.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.Alert;
import testing.sqa.drivers.DriverRemoteBrowser;

public class AcceptAlert implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {

        Alert alert = DriverRemoteBrowser.driver.switchTo().alert();
        alert.accept();


        alert.dismiss();

        DriverRemoteBrowser.driver.switchTo().alert();

    }

    public static AcceptAlert on(){
        return Instrumented.instanceOf(AcceptAlert.class).withProperties();
    }
}
