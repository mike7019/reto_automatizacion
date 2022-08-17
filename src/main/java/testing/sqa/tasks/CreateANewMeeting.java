package testing.sqa.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.sqa.interactions.ChooseOrganizer;
import testing.sqa.interactions.*;
import testing.sqa.utils.ExcelDataTable;

import java.util.ArrayList;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.sqa.userinterface.DashBoardPage.*;
import static testing.sqa.userinterface.MeetingsPage.*;
import static testing.sqa.userinterface.NewMeetingPage.*;
import static testing.sqa.userinterface.NewMeetingPage.TXT_MEETING_NAME;

public class CreateANewMeeting implements Task {

    public ArrayList<Map<String, String>> dataExcel;

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {

            dataExcel = ExcelDataTable.leerDatosDeHojaDeExcel("data.xlsx", "Hoja1");

        } catch (Exception e) {

        }
        actor.attemptsTo(
                WaitUntil.the(BTN_MEETING, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(BTN_MEETING),
                JavaScriptClick.on(BTN_MEETINGS),
                Ensure.that(LBL_TEXT).isDisplayed(),
                JavaScriptClick.on(BTN_NEW_MEETING),
                Enter.theValue(dataExcel.get(0).get("Meeting_Name")).into(TXT_MEETING_NAME),
                Click.on(TXT_MEETING_TYPE),
                ChooseMeetingType.index(2),
                Click.on(TXT_START_DATE),
                Clear.field(TXT_START_DATE),
                Enter.keyValues(dataExcel.get(0).get("Start Date")).into(TXT_START_DATE),
                JavaScriptClick.on(TXT_START_HOUR),
                Enter.keyValues(dataExcel.get(0).get("Location")).into(TXT_MEETING_NUMBER),
                JavaScriptClick.on(TXT_END_DATE),
                Clear.field(TXT_END_DATE),
                Enter.keyValues("02/02/2023").into(TXT_END_DATE),
                Click.on(TXT_LOCATION),
                ChooseLocationOptions.index(3),
                Click.on(TXT_ORGANIZED_BY),
                ChooseOrganizer.index(5),
                Click.on(TXT_UNIT),
                ChooseUnit.index(9),
                Click.on(TXT_REPORTER),
                ChooseReporter.index(3),
                Click.on(TXT_ATENDEE_LIST),
                ChooseAtendee.index(4),
                Click.on(BTN_SAVE),
                ExplicitWait.here(5),
                Ensure.that(LBL_USER_VALIDATION).isDisplayed()
        );
    }

    public static CreateANewMeeting onTheSite() {
        return Instrumented.instanceOf(CreateANewMeeting.class).withProperties();
    }
}
