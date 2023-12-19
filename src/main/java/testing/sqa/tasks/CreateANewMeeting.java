package testing.sqa.tasks;

import com.github.javafaker.Faker;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.sqa.interactions.*;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static testing.sqa.userinterfaces.DashBoardPage.*;
import static testing.sqa.userinterfaces.MeetingsPage.*;
import static testing.sqa.userinterfaces.NewMeetingPage.*;
import static testing.sqa.userinterfaces.NewMeetingPage.TXT_MEETING_NAME;

public class CreateANewMeeting implements Task {

    Faker faker = new Faker();

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_MEETING, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(BTN_MEETING),
                JavaScriptClick.on(BTN_MEETINGS),
                Ensure.that(LBL_TEXT).isDisplayed(),
                JavaScriptClick.on(BTN_NEW_MEETING),
                Enter.theValue(faker.aviation().aircraft()).into(TXT_MEETING_NAME),
                Click.on(TXT_MEETING_TYPE),
                ChooseFromList.index(LST_MEETING_TYPE, 2),
                Click.on(TXT_START_DATE),
                Clear.field(TXT_START_DATE),
                Enter.keyValues("05/04/1993").into(TXT_START_DATE),
                ChooseListSelect.index(TXT_START_HOUR, 10),
                Enter.keyValues(faker.number().digit()).into(TXT_MEETING_NUMBER),
                JavaScriptClick.on(TXT_END_DATE),
                Clear.field(TXT_END_DATE),
                Enter.keyValues("05/04/2023").into(TXT_END_DATE),
                ChooseListSelect.index(TXT_END_HOUR, 12),
                Click.on(TXT_LOCATION),
                ChooseFromList.index(LST_LOCATION_OPTIONS, 3),
                Click.on(TXT_ORGANIZED_BY),
                ChooseFromList.index(LST_ORGANIZED_BY, 5),
                Click.on(TXT_UNIT),
                SelectUnit.on(LST_UNIT, "Administration"),
                Click.on(TXT_REPORTER),
                ChooseFromList.index(LST_REPORTER, 3),
                Click.on(TXT_ATENDEE_LIST),
                ChooseFromList.index(LST_ATENDEE_LIST, 3),
                Click.on(BTN_SAVE),
                ExplicitWait.here(5),
                Ensure.that(LBL_USER_VALIDATION).isDisplayed()
        );
    }

    public static CreateANewMeeting onTheSite() {
        return Instrumented.instanceOf(CreateANewMeeting.class).withProperties();
    }
}
