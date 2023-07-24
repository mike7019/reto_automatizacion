package testing.page.tasks;

import models.setdata.AutenticarseLoombokData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.*;

public class Autenticarse implements Task {

    private final AutenticarseLoombokData autenticarseLoombokData;

    public Autenticarse(AutenticarseLoombokData autenticarseLoombokData) {
        this.autenticarseLoombokData = autenticarseLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(autenticarseLoombokData.getUsuario()).into(LoginPage.TXT_USERNAME),
                Enter.theValue(autenticarseLoombokData.getContrasena()).into(LoginPage.TXT_PASSWORD),
                Click.on(LoginPage.BTN_LOGIN)
        );
    }

    public static Autenticarse conCredenciales(AutenticarseLoombokData autenticarseLoombokData) {
        return Instrumented.instanceOf(Autenticarse.class).withProperties(autenticarseLoombokData);
    }
}
