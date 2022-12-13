package testing.page.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop implements Interaction {

    WebDriver driver;

    @Override
    public <T extends Actor> void performAs(T t) {

        //Element which needs to drag.
        WebElement from = driver.findElement(By.xpath("//*[@id='credit2']/a"));

        //Element on which need to drop.
        WebElement to = driver.findElement(By.xpath("//*[@id='bank']/li"));

        //Using Action class for drag and drop.
        Actions action = new Actions(driver);

        //Dragged and dropped.
        action.dragAndDrop(from, to).build().perform();

    }

    public static DragAndDrop on(){
        return Instrumented.instanceOf(DragAndDrop.class).withProperties();
    }

}
