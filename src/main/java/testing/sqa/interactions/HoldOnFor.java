package testing.sqa.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import testing.sqa.drivers.DriverRemoteBrowser;

import java.util.concurrent.TimeUnit;


public class HoldOnFor implements Interaction {

    private int seconds;

    public HoldOnFor(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // WaitUntil.the(BTN_CHECKOUT, isVisible()).forNoMoreThan(3).seconds(),
        DriverRemoteBrowser.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static Performable thisSeconds(int seconds)
    {
        return Instrumented.instanceOf(HoldOnFor.class).withProperties(seconds);
    }
}
