package testing.startSharp.startsharpstepdefinitions;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import testing.page.questions.ValidateTheMeetingName;
import testing.page.tasks.CreateANewBusinessUnit;
import testing.page.tasks.CreateANewMeeting;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class StartSharpBussinessStepDefinitions {


    @When("^Mike creates a new unit business and setups a meeting$")
    public void mikeCreatesANewUnitBusinessAndSetupsAMeeting() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CreateANewBusinessUnit.onTheSite(),
                CreateANewMeeting.onTheSite()
        );


    }

    @Then("^Mike will be able see the meeting was successfully scheduled$")
    public void mikeWillBeAbleSeeTheMeetingWasSuccessfullyScheduled() {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateTheMeetingName.value()));

    }

}
