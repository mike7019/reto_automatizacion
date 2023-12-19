package testing.startSharp.startsharpstepdefinitions;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;


import static testing.sqa.drivers.WebDriversSetup.driver;

public class Hooks {


    @Before
    public static void setup(){
        OnStage.setTheStage(new OnlineCast());
    }

}
