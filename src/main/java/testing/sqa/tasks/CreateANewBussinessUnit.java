package testing.sqa.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import net.serenitybdd.screenplay.waits.WaitUntil;

import testing.sqa.interactions.ChooseParentUnit;
import testing.sqa.interactions.ExplicitWait;

import testing.sqa.utils.ExcelDataTable;

import java.util.ArrayList;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.sqa.userinterface.BussinessUnitPage.*;
import static testing.sqa.userinterface.DashBoardPage.*;
import static testing.sqa.userinterface.NewBussinessUnitPage.*;


public class CreateANewBussinessUnit implements Task {


    public ArrayList<Map<String, String>> dataExcel;

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            dataExcel = ExcelDataTable.leerDatosDeHojaDeExcel("data.xlsx", "Hoja1");
        } catch (Exception ignored){}

        actor.attemptsTo(
                WaitUntil.the(BTN_ORGANIZATION, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(BTN_ORGANIZATION),
                JavaScriptClick.on(BTN_BUSSINESS_UNIT),
                JavaScriptClick.on(BTN_BUSSINESS),
                JavaScriptClick.on(BTN_NEW_BUSSINESS_UNIT),
                Enter.theValue(dataExcel.get(0).get("Bussiness_Name")).into(TXT_BUSSINESS_NAME),
                Click.on(TXT_PARENT_UNIT),
                ChooseParentUnit.index(0),
                ExplicitWait.here(5),
                JavaScriptClick.on(BTN_SAVE_UNIT),
                ExplicitWait.here(10)
        );

    }

    public static CreateANewBussinessUnit onTheSite() {
        return Instrumented.instanceOf(CreateANewBussinessUnit.class).withProperties();
    }
}
