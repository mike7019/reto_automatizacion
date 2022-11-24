package testing.startSharp.startsharpstepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import testing.sqa.drivers.DriverRemoteBrowser;
import testing.sqa.models.LoginData;
import testing.sqa.questions.ValidateTheMessage;
import testing.sqa.tasks.DoTheLogin;

import java.util.List;

import static org.hamcrest.core.IsEqual.*;
import static testing.sqa.utils.GlobalData.URL;

public class StartSharpLoginStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^That Mike opens the url to see the login page$")
    public void thatMikeOpensTheHttpsSerenityIsDemoToSeeTheLoginPage() {

        DriverRemoteBrowser.withTheseOptions();
        OnStage.theActorCalled("Mike").can(BrowseTheWeb.with(DriverRemoteBrowser.on(URL)));

    }

    @When("^Mike types the following data$")
    public void MikeTypesTheFollowingData(List<LoginData> loginDataList) {


        OnStage.theActorInTheSpotlight().attemptsTo(
                DoTheLogin.onTheSite()
                        .withThisUser(loginDataList.get(0).getUser())
                        .andThisPassword(loginDataList.get(0).getPassword())
        );
    }

    @Then("^Mike will be able to see the (.*)$")
    public void mikeWillBeAbleToSeeTheDashBoard(String text) {

        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateTheMessage.value(), equalTo(text)));

    }
}
