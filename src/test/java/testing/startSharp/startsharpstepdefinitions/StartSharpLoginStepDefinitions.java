package testing.startSharp.startsharpstepdefinitions;



import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import testing.page.drivers.WebDriversSetup;
import testing.page.models.LoginData;
import testing.page.models.setdata.AuthLoombokData;
import testing.page.questions.ValidateTheMessage;
import testing.page.tasks.DoTheLogin;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static testing.page.utils.GlobalData.URL;

public class StartSharpLoginStepDefinitions {

    @Given("^That Mike opens the url to see the login page$")
    public void thatMikeOpensTheHttpsSerenityIsDemoToSeeTheLoginPage() {
        //WebDriversSetup.withChromeOptions();
        OnStage.theActorCalled("Mike").wasAbleTo(Open.url(URL));

    }

    @When("^Mike types the following data$")
    public void MikeTypesTheFollowingData(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DoTheLogin.onTheSite()
                        .withThisUser(AuthLoombokData.setData(table).get(0).getUser())
                        .andThisPassword(AuthLoombokData.setData(table).get(0).getPassword())
        );
    }

    @Then("^Mike will be able to see the (.*)$")
    public void mikeWillBeAbleToSeeTheDashBoard(String text) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateTheMessage.value(), containsString(text)));

    }
}
