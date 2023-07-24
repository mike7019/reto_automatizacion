package testing.page.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.page.models.setdata.AgregarAlCarritoLoombokData;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.page.userinterfaces.CarritoPage.*;
import static testing.page.userinterfaces.CheckoutPage.*;
import static testing.page.userinterfaces.MenuPage.*;


public class Agregar implements Task {
    private final AgregarAlCarritoLoombokData agregarAlCarritoLoombokData;

    public Agregar(AgregarAlCarritoLoombokData agregarAlCarritoLoombokData) {
        this.agregarAlCarritoLoombokData = agregarAlCarritoLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_AÑADIR.of(agregarAlCarritoLoombokData.getNombreProducto()), isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_AÑADIR.of(agregarAlCarritoLoombokData.getNombreProducto())),
                Click.on(BTN_CARRITO),
                Ensure.that(TXT_VALIDAR_PRODUCTO).textContent().contains(agregarAlCarritoLoombokData.getNombreProducto()),
                Click.on(BTN_CHECKOUT),
                Enter.theValue(agregarAlCarritoLoombokData.getNombre()).into(TXT_NOMBRE),
                Enter.theValue(agregarAlCarritoLoombokData.getApellido()).into(TXT_APPELIDO),
                Enter.theValue(agregarAlCarritoLoombokData.getZip()).into(TXT_ZIP),
                Click.on(BTN_CONTINUE),
                Click.on(BTN_FINISH)
        );
    }

    public static Agregar alCarrito(AgregarAlCarritoLoombokData agregarAlCarritoLoombokData) {
        return Instrumented.instanceOf(Agregar.class).withProperties(agregarAlCarritoLoombokData);
    }
}
