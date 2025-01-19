package starter;

import Utils.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.platform.suite.api.*;
import org.junit.runner.RunWith;
import java.io.IOException;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@CPL001",
        glue = "starter/stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CucumberTestSuite {
    @BeforeSuite
    public static void test() throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features");
    }
}
