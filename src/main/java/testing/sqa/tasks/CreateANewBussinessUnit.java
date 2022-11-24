package testing.sqa.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import testing.sqa.interactions.ChooseFromList;
import testing.sqa.utils.ExcelDataTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.sqa.userinterfaces.BussinessUnitPage.*;
import static testing.sqa.userinterfaces.DashBoardPage.*;
import static testing.sqa.userinterfaces.NewBussinessUnitPage.*;


public class CreateANewBussinessUnit implements Task {



    public ArrayList<Map<String, String>> dataExcel;

    @Override
    public <T extends Actor> void performAs(T actor) {

            try {
                dataExcel = ExcelDataTable.ReadData("data.xlsx", "Sheet1");
            } catch (IOException e) {
                e.printStackTrace();
            }

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

    public static CreateANewBussinessUnit onTheSite() {
        return Instrumented.instanceOf(CreateANewBussinessUnit.class).withProperties();
    }
}
