package neworangehrm.com.opensourcehrm.steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import neworangehrm.com.opensourcehrm.pages.LoginPage;
import neworangehrm.com.opensourcehrm.util.DriverUtil;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

import static neworangehrm.com.opensourcehrm.pages.LoginPage.getElementLocator;

/**
 * Created by Viswa on 12/25/2017.
 */
public class LoginPageSteps implements En {
    DriverUtil driverUtil = new DriverUtil();
    WebDriver driver = driverUtil.getDriverInstance();
    Map<String, String> state = new HashMap<>();

    public LoginPageSteps() {
        When("^I view login form$", () -> {
            if (!driver.findElement(getElementLocator("username")).isEnabled())
                state.put("Username", "Not Displayed");

            if (!driver.findElement(getElementLocator("password")).isEnabled())
                state.put("Password", "Not Displayed");

            if (!driver.findElement(getElementLocator("Login")).isEnabled())
                state.put("Login", "Not Enabled");
        });
        Then("^The required fields are displayed$", () -> {
            Assert.assertTrue(state.values().toString(), state.isEmpty());
        });

    }

}
