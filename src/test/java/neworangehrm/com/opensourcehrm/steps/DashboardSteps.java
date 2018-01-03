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
public class DashboardSteps implements En {

    DriverUtil driverUtil = new DriverUtil();
    Map<String, String> state = new HashMap<>();

    public DashboardSteps() {
        When("^I view welcome message$", () -> {
            state.put("name", driverUtil.getDriverInstance().findElement(PageUtil.commonWebPage.getElementLocator("welcomemessage")).getText());
            //state.put("name", driverUtil.getDriverInstance().findElement(By.id("welcome")).getText());
        });
        Then("^Username is displayed$", () -> {
            Assert.assertTrue("Welcome message is missing user name", state.get("name").contains("Admin"));
        });

    }
}
