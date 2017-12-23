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
import neworangehrm.com.opensourcehrm.util.DataUtil;

import static neworangehrm.com.opensourcehrm.pages.LoginPage.*;
import static neworangehrm.com.opensourcehrm.util.DataUtil.baseUrl;

public class CommonSteps implements En {

    DriverUtil driverUtil = new DriverUtil();
    WebDriver driver = driverUtil.getDriverInstance();

    @Before
    public void setUp(){
        DataUtil.loadProperties();
    }
    public CommonSteps() {
        Given("^I am on the (.*) page$", (String webPage) -> {
            driver.get(baseUrl);
        });

        When("^I fill the login form and submit$", () -> {
            driver.findElement(getElementLocator("username")).sendKeys("admin");
            driver.findElement(getElementLocator("password")).sendKeys("admin");
            driver.findElement(getElementLocator("Login")).click();
        });

        Then("^The page is displayed$", () -> {
            Assert.assertEquals("Mismatch in page title", "OrangeHRM", driver.getTitle());
        });
    }

    @After
    public void cleanup(Scenario scenario) {
        try {
            TakesScreenshot takesScreenshot = ((TakesScreenshot)driver);
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }catch (WebDriverException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}