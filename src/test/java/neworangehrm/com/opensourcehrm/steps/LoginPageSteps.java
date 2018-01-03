package neworangehrm.com.opensourcehrm.steps;

import cucumber.api.java8.En;
import neworangehrm.com.opensourcehrm.util.DriverUtil;
import neworangehrm.com.opensourcehrm.util.PageUtil;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Viswa on 12/25/2017.
 */
public class LoginPageSteps implements En {
    DriverUtil driverUtil = new DriverUtil();
    Map<String, String> state = new HashMap<>();

    public LoginPageSteps() {
        When("^I view login form$", () -> {
            int i = 0;

            if (!driverUtil.getDriverInstance().findElement(PageUtil.commonWebPage.getElementLocator("username")).isEnabled())
                state.put("Username", "Not Displayed");

            if (!driverUtil.getDriverInstance().findElement(PageUtil.commonWebPage.getElementLocator("password")).isEnabled())
                state.put("Password", "Not Displayed");

            if (!driverUtil.getDriverInstance().findElement(PageUtil.commonWebPage.getElementLocator("Login")).isEnabled())
                state.put("Login", "Not Enabled");
        });

        Then("^The required fields are displayed$", () -> {
            Assert.assertTrue(state.values().toString(), state.isEmpty());
        });

    }

}
