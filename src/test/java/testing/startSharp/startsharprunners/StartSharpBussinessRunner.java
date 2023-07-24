package testing.startSharp.startsharprunners;

import io.cucumber.core.snippets.SnippetType;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        features = "src/test/resources/features/start_sharp_bussiness.feature",
        glue = "testing.startSharp.startsharpstepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class StartSharpBussinessRunner {
}
