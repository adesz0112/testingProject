import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:test-results/cucumber-reports.html"},
        monochrome = true
)

public class AllTestRunner {
}
