package testing.page.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import testing.page.drivers.DriverRemoteBrowser;

import java.util.concurrent.TimeUnit;


public class HoldOnFor implements Interaction {

    private int seconds;

    public HoldOnFor(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        DriverRemoteBrowser.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

    }

    public static Performable thisSeconds(int seconds)
    {
        return Instrumented.instanceOf(HoldOnFor.class).withProperties(seconds);
    }
}
