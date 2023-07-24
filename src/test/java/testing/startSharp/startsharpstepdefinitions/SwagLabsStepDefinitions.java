package testing.startSharp.startsharpstepdefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.hamcrest.Matchers;
import testing.page.interactions.SelfHealingTest;
import testing.page.models.Constantes;
import testing.page.models.setdata.AbrirLoombokData;
import testing.page.models.setdata.AgregarAlCarritoLoombokData;
import testing.page.models.setdata.AutenticarseLoombokData;
import testing.page.models.setdata.FinalizarCompraLoombokData;
import testing.page.questions.ValidarBooleano;
import testing.page.questions.ValidarTexto;
import testing.page.tasks.*;
import testing.page.tasks.Interact;

import static testing.page.userinterfaces.CheckoutPage.TXT_CONFIRMAR;


public class SwagLabsStepDefinitions {

    @Given("el actor ingresa a saucedemo.com")
    public void elActorIngresaASauceDemoCom(DataTable table) {
        OnStage.theActorCalled(Constantes.ACTOR).wasAbleTo(Open.url(AbrirLoombokData.setData(table).get(0).getUrl()));
//        SelfHealingTest.withChromeOptions();
//        OnStage.theActorCalled(Constantes.ACTOR).wasAbleTo(Open.url("http://127.0.0.1:5500/src/prueba.html"));

    }

    @When("el actor se autentica con la siguiente informacion")
    public void elActorSeAutenticaConLaSiguienteInformacion(DataTable table) {
     //   OnStage.theActorInTheSpotlight().attemptsTo(Interact.with());
        OnStage.theActorInTheSpotlight().attemptsTo(
                Autenticarse.conCredenciales(AutenticarseLoombokData.setData(table).get(0))
        );
    }

    @When("agrega el producto al carrito y hace el checkout")
    public void agregaElProductoAlCarritoYHaceElCheckout(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Agregar.alCarrito(AgregarAlCarritoLoombokData.setData(table).get(0))
        );
    }

    @Then("valida que el producto se compro de manera exitosa")
    public void validaQueElProductoSeComproDeManeraExitosa(DataTable table) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarTexto.delElemento(TXT_CONFIRMAR), Matchers.containsString(FinalizarCompraLoombokData.setData(table).get(0).getMensajeExitoso())));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarBooleano.delElemento(TXT_CONFIRMAR)));
        Ensure.thatTheAnswerTo(ValidarTexto.delElemento(TXT_CONFIRMAR)).contains(FinalizarCompraLoombokData.setData(table).get(0).getMensajeExitoso());
        Ensure.thatTheAnswerTo(ValidarBooleano.delElemento(TXT_CONFIRMAR)).isTrue();
        Ensure.that(TXT_CONFIRMAR).textContent().contains(FinalizarCompraLoombokData.setData(table).get(0).getMensajeExitoso());
    }
}
