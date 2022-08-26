package testing.sqa.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import static testing.sqa.drivers.DriverRemoteBrowser.driver;
import static testing.sqa.userinterface.MovistarPortabilidadPospagoPage.TXT_PLAN_VALIDACION;

public class ScrollTo implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
      //  WebElement Element = driver.findElement(By.xpath("//"));
        js.executeScript("arguments[0].scrollIntoView();", TXT_PLAN_VALIDACION);

    }

    public static ScrollTo to(){
        return Instrumented.instanceOf(ScrollTo.class).withProperties();
    }
}
