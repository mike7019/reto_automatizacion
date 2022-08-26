package testing.sqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import testing.sqa.userinterface.AdvantageMainPage;



public class Answer implements Question<Boolean> {

    private String target;

    public Answer(String target) {
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String userLogged = Text.of(AdvantageMainPage.LBL_USERNAME_LOGGED).viewedBy(actor).asString();

        if (target.equals(userLogged)){
            result = true;
        }else{
            result = false;
        }
        return result;
    }

    public static Answer toThe(String target) {
        return new Answer(target);
    }

}
