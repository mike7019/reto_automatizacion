package testing.startSharp.startsharprunners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        features = "src/test/resources/features/startSharpLogin.feature",
        glue = "testing.startSharp.startsharpstepdefinitions",
        snippets = SnippetType.CAMELCASE)

public class StartSharpDoTheLoginRunner {
}
