package testing.sqa.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class task implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(elemento, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static CreateANewMeeting onTheSite() {
        return Instrumented.instanceOf(CreateANewMeeting.class).withProperties();
    }
}