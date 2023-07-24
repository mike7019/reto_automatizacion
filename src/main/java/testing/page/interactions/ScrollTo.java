package testing.page.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static testing.page.drivers.WebDriversSetup.driver;

public class ScrollTo implements Interaction {

    Target element;


    @Override
    public <T extends Actor> void performAs(T actor) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.xpath("//"));
        js.executeScript("arguments[0].scrollIntoView();", element);

    }

    public static ScrollTo to(Target element){
        return Instrumented.instanceOf(ScrollTo.class).withProperties(element);
    }

}
