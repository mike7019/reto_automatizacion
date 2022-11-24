package testing.startSharp.startsharpstepdefinitions;

import cucumber.api.java.Before;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import testing.sqa.questions.ValidateTheMeetingName;
import testing.sqa.tasks.CreateANewBussinessUnit;
import testing.sqa.tasks.CreateANewMeeting;
import testing.sqa.tasks.SelectCountry;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class StartSharpBussinessStepDefinitions {


    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^Mike creates a new unit bussiness and setups a meeting$")
    public void mikeCreatesANewUnitBussinessAndSetupsAMeeting() {
       /* OnStage.theActorInTheSpotlight().attemptsTo(
                CreateANewBussinessUnit.onTheSite(),
                CreateANewMeeting.onTheSite()
        );*/
        OnStage.theActorInTheSpotlight().attemptsTo(SelectCountry.onTheSite());

    }

    @Then("^Mike will be able see the meeting was succesfully scheduled$")
    public void mikeWillBeAbleSeeTheMeetingWasSuccesfullyScheduled() {
      //  OnStage.theActorInTheSpotlight().should(seeThat(ValidateTheMeetingName.value()));

    }
}
