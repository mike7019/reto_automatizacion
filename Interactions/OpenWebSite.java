package testing.sqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import testing.sqa.utils.ExcelDataTable;

import java.io.IOException;

public class OpenWebSite implements Task {


        ExcelDataTable data = new ExcelDataTable();

        public static OpenWebSite openWebSite(){
            return Tasks.instrumented(OpenWebSite.class);
        }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(Open.url(data.ReadDataSheet("info", "Data.xlsx", 1, 1)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}

