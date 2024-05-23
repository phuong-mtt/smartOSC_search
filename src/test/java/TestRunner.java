import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

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
}
