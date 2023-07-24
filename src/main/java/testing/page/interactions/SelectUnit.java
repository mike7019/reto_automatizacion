package testing.page.interactions;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SelectUnit implements Interaction {

    private final Target element;
    private final String bussinessName;

    public SelectUnit(Target element, String bussinessName) {
        this.element = element;
        this.bussinessName = bussinessName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            WebElement listLocation = element.resolveFor(actor);
            List<WebElement> options = listLocation.findElements(By.tagName("li"));
            for (WebElement i : options) {
                if (i.getText().contains(bussinessName)) {
                    i.click();
                    break;
                }
            }
            // If the option is not found, the loop will simply complete without clicking anything
        } catch (Exception e) {
            System.out.println("the bussiness name couldn't be found: "+e);
        }

    }

    public static SelectUnit on(Target element, String bussinessName) {
        return Instrumented.instanceOf(SelectUnit.class).withProperties(element, bussinessName);
    }
}
