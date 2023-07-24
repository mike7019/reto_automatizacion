package testing.startSharp.startsharprunners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        features = "src/test/resources/features/start_sharp_login.feature",
        glue = "testing.startSharp.startsharpstepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class StartSharpDoTheLoginRunner {
    @BeforeClass
    public static void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

}
