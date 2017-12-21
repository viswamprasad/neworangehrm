package neworangehrm.com.opensourcehrm.steps;

/**
 * Created by Viswa on 12/20/2017.
 */

import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import neworangehrm.com.opensourcehrm.util.DriverUtil;
import neworangehrm.com.opensourcehrm.util.DataUtil;
import static neworangehrm.com.opensourcehrm.pages.LoginPage.*;

public class CommonSteps implements En {

    DriverUtil driverUtil = new DriverUtil();
    WebDriver driver = driverUtil.getDriverInstance();

    public CommonSteps() {

        Given("I am on the (.*) page", (String webPage) -> {
            driver.get(DataUtil.baseUrl);
        });

        When("I enter valid (.*)", (String a) -> {
            driver.findElement(getElementLocator("username")).sendKeys("admin");
            driver.findElement(getElementLocator("password")).sendKeys("admin");
            driver.findElement(getElementLocator("Login")).click();
        });

        Then("(.*) dashboard page displayed", (String b) -> {
            Assert.assertEquals("Mismatch in page title","OrangeHRM",driver.getTitle());
            driver.close();
        });
    }
}