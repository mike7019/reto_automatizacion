package testing.startSharp.startsharpstepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import testing.sqa.drivers.WebDriversSetup;
import testing.sqa.models.LoginData;
import testing.sqa.questions.ValidateTheMessage;
import testing.sqa.tasks.DoTheLogin;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static testing.sqa.utils.GlobalData.URL;

public class StartSharpLoginStepDefinitions {


    @Given("^That Mike opens the url to see the login page$")
    public void thatMikeOpensTheHttpsSerenityIsDemoToSeeTheLoginPage() {
        OnStage.theActorCalled("Mike").wasAbleTo(Open.url(URL));

    }
    @When("^Mike types the following data$")
    public void MikeTypesTheFollowingData(DataTable loginDataList) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DoTheLogin.onTheSite()
                        .withThisUser(LoginData.setData(loginDataList).get(0).getUser())
                        .andThisPassword(LoginData.setData(loginDataList).get(0).getPass())
        );
    }

    @Then("^Mike will be able to see the (.*)$")
    public void mikeWillBeAbleToSeeTheExploraYGestionaTusProductos(String text) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateTheMessage.value(), containsString(text)));
    }
}
