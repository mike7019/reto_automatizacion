package testing.sqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static testing.sqa.userinterfaces.LoginPage.LBL_VALIDATION;

public class ValidateTheMessage implements Question<String> {


    @Override
    public String answeredBy(Actor actor) {
        return LBL_VALIDATION.resolveFor(actor).getText();
    }

    public static Question<String> value() {
        return new ValidateTheMessage();
    }

}
