package testing.page.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidarBooleano implements Question<Boolean> {

    private final Target element;

    public ValidarBooleano(Target element) {
        this.element = element;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return element.resolveFor(actor).isDisplayed();
    }

    public static Question<Boolean> delElemento(Target element) {
        return new ValidarBooleano(element);
    }
}
