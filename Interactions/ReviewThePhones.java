package testing.sqa.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import testing.sqa.userinterface.MovistarEquiposRenovarPage;
import testing.sqa.utils.ExcelDataTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.sqa.userinterface.MovistarEquiposRenovarPage.*;


public class ReviewThePhones implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {

        String currHandle = BrowseTheWeb.as(actor).getDriver().getWindowHandle();
        List<WebElementFacade> phonePrice = MovistarEquiposRenovarPage.TXT_PRICE.resolveAllFor(actor);

        for (int i = 0; i < phonePrice.size(); i++) {

            List<WebElementFacade> buyOnline = MovistarEquiposRenovarPage.BTN_BUY_ONLINE.resolveAllFor(actor);
            List<WebElementFacade> currentName = MovistarEquiposRenovarPage.TXT_PHONE_NAME.resolveAllFor(actor);
            List<WebElementFacade> phonePrecio = MovistarEquiposRenovarPage.TXT_PRICE.resolveAllFor(actor);
            List<WebElementFacade> normalprice = MovistarEquiposRenovarPage.TXT_NORMAL_PRICE.resolveAllFor(actor);

//            String currentPrice = phonePrecio.get(i).getText();
            String currName = currentName.get(i).getText();
            String currNormal = normalprice.get(i).getText();
            String currentPrice = phonePrecio.get(i).getText();

//            System.out.println("..........." + i + "..............");
            System.out.println("" +currName);
            System.out.println(" "+currentPrice);
            System.out.print(" "+currNormal);
//            System.out.println("..............................");


//                actor.attemptsTo(
//                        HoldOnFor.thisSeconds(15),
//                        WaitUntil.the(TXT_PRICE, isCurrentlyVisible()).forNoMoreThan(20).seconds(),
//                        Ensure.that(TXT_PRICE).text().isEqualTo(currentPrice),
//                        Hit.the(Keys.ENTER).keyIn(buyOnline.get(i)),
//                        HoldOnFor.thisSeconds(150),
//                        SwitchToNewTab.change(),
//                        WaitUntil.the(TXT_E_SHOP_PRICE, isVisible()).forNoMoreThan(150).seconds(),
//                        Ensure.that(TXT_E_SHOP_PRICE).text().isEqualTo(currentPrice),
//                        HoldOnFor.thisSeconds(150),
//                    //    CloseCurrentTab.on(),
//                        GoToPreviousPage.onThePage(i),
//                        Switch.toWindow(currHandle),
//                        HoldOnFor.thisSeconds(150),
//                        WaitUntil.the(TXT_PRICE, isVisible()).forNoMoreThan(150).seconds()
//                );
        }
    }


    public static ReviewThePhones onThePage() {
        return Instrumented.instanceOf(ReviewThePhones.class).withProperties();
    }
}
