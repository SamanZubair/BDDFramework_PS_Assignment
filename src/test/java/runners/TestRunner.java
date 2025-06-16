package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.FilePaths;

@CucumberOptions(
        features = FilePaths.FEATURES_PATH,
        glue = {"steps", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
        public TestRunner() {
                System.out.println("✅ TestRunner is being invoked.");
        }
}
