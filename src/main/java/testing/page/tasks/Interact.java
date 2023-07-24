package testing.page.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Interact implements Task {
    private static final Target TXT_INPUT = Target.the("input uno")
            .locatedBy("//input[@placeholder='york']");
    private static final Target TXT_INPUTD = Target.the("input dos")
            .locatedBy("//input[@placeholder='lastname']");
    private static final Target BTN_SUBMIT = Target.the("button")
            .locatedBy("//button[@type='submit']");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_INPUT, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue("ECHE").into(TXT_INPUT),
                Enter.theValue("Nojoda").into(TXT_INPUTD),
                Click.on(BTN_SUBMIT)
        );
    }

    public static Interact with(){
        return Instrumented.instanceOf(Interact.class).withProperties();
    }
}
