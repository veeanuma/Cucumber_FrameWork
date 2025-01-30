package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        }
)

    public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true) // Enable parallel execution of scenarios
    public Object[][] scenarios() {
        return super.scenarios();
    }
    }

