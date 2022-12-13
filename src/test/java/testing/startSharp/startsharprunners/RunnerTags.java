package testing.startSharp.startsharprunners;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;

import cucumber.api.SnippetType;
import testing.page.utils.BeforeSuite;
import testing.page.utils.DataToFeature;


@CucumberOptions (
        features = "src/test/resources/features/features.feature",
        tags= {"@CrearUsuarioExcel"},
        snippets= SnippetType.CAMELCASE)

@RunWith(CustomRunner.class)

public class RunnerTags {

    @BeforeSuite

    public static void test() throws InvalidFormatException, IOException {

        DataToFeature.overrideFeatureFiles("./src/test/resources/features/features.feature");

    }

}