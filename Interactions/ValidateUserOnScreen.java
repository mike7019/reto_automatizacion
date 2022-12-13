package testing.page.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static testing.page.userinterfaces.AdvantageMainPage.*;

public class ValidateUserOnScreen implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LBL_USERNAME_LOGGED.resolveFor(actor).getText();
    }

    public static Question<String> value() {
        return new ValidateUserOnScreen();
    }
}
