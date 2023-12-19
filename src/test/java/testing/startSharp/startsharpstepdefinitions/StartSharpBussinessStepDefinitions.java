package testing.startSharp.startsharpstepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import testing.sqa.questions.ValidateTheMeetingName;
import testing.sqa.tasks.CreateANewBussinessUnit;
import testing.sqa.tasks.CreateANewMeeting;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class StartSharpBussinessStepDefinitions {


    @When("^Mike creates a new unit (.*) and setups a meeting$")
    public void mikeCreatesANewUnitBussinessAndSetupsAMeeting(String business) {
        OnStage.theActorInTheSpotlight().attemptsTo(CreateANewBussinessUnit.onTheSite(business));
        OnStage.theActorInTheSpotlight().attemptsTo(CreateANewMeeting.onTheSite());

    }

    @Then("^Mike will be able see the meeting was succesfully scheduled$")
    public void mikeWillBeAbleSeeTheMeetingWasSuccesfullyScheduled() {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateTheMeetingName.value()));

    }
}
