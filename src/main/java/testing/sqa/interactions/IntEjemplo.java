package testing.sqa.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class IntEjemplo implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

    }

    public static IntEjemplo on(){
        return Instrumented.instanceOf(IntEjemplo.class).withProperties();
    }
}
