package testing.sqa.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.sqa.userinterface.LoginPage.*;

public class DoTheLogin implements Task {

    private String user;
    private String password;


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_USER, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(user).into(TXT_USER),
                Enter.theValue(password).into(TXT_PASSWORD),
                JavaScriptClick.on(BTN_LOGIN),
                WaitUntil.the(LBL_VALIDATION, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static DoTheLogin onTheSite() {
        return Instrumented.instanceOf(DoTheLogin.class).withProperties();
    }

    public DoTheLogin user(String user) {
        this.user = user;
        return this;
    }

    public DoTheLogin password(String password) {
        this.password = password;
        return this;
    }

}
