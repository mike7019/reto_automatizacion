package testing.sqa.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import testing.sqa.interactions.HoldOnFor;
import testing.sqa.interactions.SelectUnit;
import testing.sqa.userinterfaces.ClientesPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.sqa.userinterfaces.ClientesPage.TXT_COUNTRY;

public class SelectCountry implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ClientesPage.LABEL_MENU_VIENTO_NORTE),
                Click.on(ClientesPage.LABEL_SUBMENU_CLIENTES),
                Click.on(ClientesPage.BTN_NUEVO_CLIENTE),
                HoldOnFor.thisSeconds(5),
                Click.on(TXT_COUNTRY),
                SelectUnit.on(ClientesPage.SELECT_PAIS_UL,"Argentina"),
                Enter.theValue("cliente.get(0).getId()").into(ClientesPage.INPUT_ID),
                Enter.theValue("cliente.get(0).getEmpresa()").into(ClientesPage.INPUT_NOMBRE_EMPRESA),
                Enter.theValue("cliente.get(0).getnContacto()").into(ClientesPage.INPUT_NOMBRE_CONTACTO),
                Enter.theValue("cliente.get(0).gettContacto()").into(ClientesPage.INPUT_TITULO_CONTACTO),
                Enter.theValue("cliente.get(0).getRepresentante()").into(ClientesPage.SELECT_REPRESENTANTE),
                Hit.the(Keys.ENTER).into(ClientesPage.SELECT_REPRESENTANTE),
                Enter.theValue("cliente.get(0).getDireccion()").into(ClientesPage.INPUT_DIRECCION),
                HoldOnFor.thisSeconds(5),

                HoldOnFor.thisSeconds(5)



        );
    }

   public static SelectCountry onTheSite(){
        return Instrumented.instanceOf(SelectCountry.class).withProperties();
    }

}