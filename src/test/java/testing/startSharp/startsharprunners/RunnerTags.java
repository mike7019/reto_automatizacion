package testing.startSharp.startsharprunners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@CucumberOptions(
        features = "src/test/resources/features/features.feature",
        tags= "",
        snippets= CucumberOptions.SnippetType.CAMELCASE)

@RunWith(CustomRunner.class)

public class RunnerTags {

    @BeforeClass
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }
}