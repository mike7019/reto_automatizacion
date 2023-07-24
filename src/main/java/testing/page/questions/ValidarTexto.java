package testing.page.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidarTexto implements Question<String> {

    private final Target element;

    public ValidarTexto(Target element) {
        this.element = element;
    }

    @Override
    public String answeredBy(Actor actor) {
        return element.resolveFor(actor).getText();
    }

    public static Question<String> delElemento(Target element) {
        return new ValidarTexto(element);
    }

}
