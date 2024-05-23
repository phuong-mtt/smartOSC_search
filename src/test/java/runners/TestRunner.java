package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefs",
        plugin = {"pretty", "html:target/cucumberReport.xml", "json: target/cucumberReport.json"},
        dryRun = false, //dryRun = true -> only check steps initialed or not instead of executing them
        monochrome = true, //return pretty format on console
        tags = "@automated"
)

public class TestRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner cucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setupClass() {
        cucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @DataProvider()
    public Object[][] scenarios() {
        if (cucumberRunner == null) {
            return new Object[0][0];
        }
        return cucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (cucumberRunner == null) {
            return;
        }
        cucumberRunner.finish();
    }
}
