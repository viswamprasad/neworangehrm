package neworangehrm.com.opensourcehrm.steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import neworangehrm.com.opensourcehrm.util.DriverUtil;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

import static neworangehrm.com.opensourcehrm.pages.DashboardPage.*;
/**
 * Created by Viswa on 12/25/2017.
 */
public class DashboardSteps implements En {
    DriverUtil driverUtil = new DriverUtil();
    WebDriver driver = driverUtil.getDriverInstance();
    Map<String, String> state = new HashMap<>();
    public DashboardSteps() {
        When("^I view welcome message$", () -> {
            state.put("name", driver.findElement(getElementLocator("welcomemessage")).getText());
        });
        Then("^Username is displayed$", () -> {
            Assert.assertTrue("Welcome message is missing user name", state.get("name").contains("Admin"));
        });

    }
}
