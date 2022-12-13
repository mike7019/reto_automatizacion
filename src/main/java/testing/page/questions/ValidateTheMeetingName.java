package testing.page.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import testing.page.userinterfaces.MeetingsPage;

public class ValidateTheMeetingName implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return MeetingsPage.LBL_USER_VALIDATION.resolveFor(actor).isDisplayed();
    }

    public static Question<Boolean> value() {
        return new ValidateTheMeetingName();
    }


}
