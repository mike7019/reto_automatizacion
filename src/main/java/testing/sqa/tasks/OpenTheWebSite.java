package testing.sqa.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenTheWebSite implements Task {

    private final String url;

    public OpenTheWebSite(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }

    public static OpenTheWebSite on(String url){
        return Instrumented.instanceOf(OpenTheWebSite.class).withProperties(url);
    }
}
