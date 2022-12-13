package testing.page.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import testing.page.userinterfaces.MiMovistarPage;
import testing.page.userinterfaces.MovistarEquiposRenovarPage;
import testing.page.userinterfaces.MovistarMainPage;

import java.util.List;

import static testing.page.userinterfaces.MovistarMainPage.BTN_DROPDOWN;

public class ReviewEachButton implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        String currHandle = BrowseTheWeb.as(actor).getDriver().getWindowHandle();
        List<WebElementFacade> buttons = MiMovistarPage.BTN_STAIR.resolveAllFor(actor);


        for (int i = 0; i < buttons.size(); i++) {
            List<WebElementFacade> buttonsNew = MiMovistarPage.BTN_STAIR.resolveAllFor(actor);

            actor.attemptsTo(
                    Click.on(buttonsNew.get(i)),
                    ExplicitWait.here(10)

//                    CloseCurrentTab.on(),
//                    GoToPreviousPage.onThePage()
            );


//            for (int j = 0; j < options.size(); j++) {
//
//                actor.attemptsTo(
//                        Click.on(options.get(j)),
//                        ExplicitWait.here(10),
//                        //CloseCurrentTab.on(),
//                        GoToPreviousPage.onThePage()
//
//                );

        }

    }

    public static ReviewEachButton onTheFront() {
        return Instrumented.instanceOf(ReviewEachButton.class).withProperties();
    }
}
