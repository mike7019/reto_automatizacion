package testing.sqa.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class ExplicitWait implements Interaction {

    int secs;

    public ExplicitWait(int secs) {
        this.secs = secs;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static ExplicitWait here(int secs){
        return Instrumented.instanceOf(ExplicitWait.class).withProperties(secs);
    }
}
