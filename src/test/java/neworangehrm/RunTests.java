package neworangehrm;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Unit test for simple App.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber"}, features = "src/test/resources/scenarios")

public class RunTests {
}
