package neworangehrm.com.opensourcehrm.steps;

/**
 * Created by Viswa on 12/20/2017.
 */

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import neworangehrm.com.opensourcehrm.util.DriverUtil;

import static neworangehrm.com.opensourcehrm.pages.LoginPage.*;
import static neworangehrm.com.opensourcehrm.util.DataUtil.*;
import static neworangehrm.com.opensourcehrm.util.DataUtil.baseUrl;

public class CommonSteps implements En {

    DriverUtil driverUtil;

    @Before
    public void setUp() {

        driverUtil = new DriverUtil();
    }
    public CommonSteps() {
        Given("^I am on the (.*) page$", (String webPage) -> {
            switch(webPage.toLowerCase()){
                case "login":
                    driverUtil.getDriverInstance().get(baseUrl);
                    break;
                case "dashboard":
                    driverUtil.getDriverInstance().get(baseUrl);
                    driverUtil.getDriverInstance().findElement(getElementLocator("username")).sendKeys("admin");
                    driverUtil.getDriverInstance().findElement(getElementLocator("password")).sendKeys("admin");
                    driverUtil.getDriverInstance().findElement(getElementLocator("Login")).click();
                    break;
                default:
                    driverUtil.getDriverInstance().get(baseUrl);
            }

        });

        When("^I fill the login form and submit$", () -> {
            driverUtil.getDriverInstance().findElement(getElementLocator("username")).sendKeys("admin");
            driverUtil.getDriverInstance().findElement(getElementLocator("password")).sendKeys("admin");
            driverUtil.getDriverInstance().findElement(getElementLocator("Login")).click();
        });

        Then("^The page is displayed$", () -> {
            Assert.assertEquals("Mismatch in page title", "OrangeHRM", driverUtil.getDriverInstance().getTitle());
        });
    }

    @After
    public void cleanup(Scenario scenario) {
        try {
            TakesScreenshot takesScreenshot = ((TakesScreenshot)driverUtil.getDriverInstance());
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }catch (WebDriverException e) {
            e.printStackTrace();
        }
        driverUtil.getDriverInstance().quit();
        driverUtil.clear();
    }
}