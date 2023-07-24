package testing.page.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.page.interactions.ChooseFromList;

import java.util.ArrayList;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.page.userinterfaces.BussinessUnitPage.BTN_BUSSINESS;
import static testing.page.userinterfaces.BussinessUnitPage.BTN_NEW_BUSSINESS_UNIT;
import static testing.page.userinterfaces.DashBoardPage.BTN_BUSSINESS_UNIT;
import static testing.page.userinterfaces.DashBoardPage.BTN_ORGANIZATION;
import static testing.page.userinterfaces.NewBussinessUnitPage.*;


public class CreateANewBusinessUnit implements Task {



    public ArrayList<Map<String, String>> dataExcel;

    @Override
    public <T extends Actor> void performAs(T actor) {

//            try {
//                dataExcel = ExcelDataTable.ReadData("data.xlsx", "Sheet1");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            actor.attemptsTo(
                WaitUntil.the(BTN_ORGANIZATION, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(BTN_ORGANIZATION),
                JavaScriptClick.on(BTN_BUSSINESS_UNIT),
                JavaScriptClick.on(BTN_BUSSINESS),
                JavaScriptClick.on(BTN_NEW_BUSSINESS_UNIT),
                Enter.theValue(dataExcel.get(0).get("Bussiness_Name")).into(TXT_BUSSINESS_NAME),
                Click.on(TXT_PARENT_UNIT),
                ChooseFromList.index(LST_PARENT_UNIT,0),
                JavaScriptClick.on(BTN_SAVE_UNIT)

        );

    }

    public static CreateANewBusinessUnit onTheSite() {
        return Instrumented.instanceOf(CreateANewBusinessUnit.class).withProperties();
    }
}
