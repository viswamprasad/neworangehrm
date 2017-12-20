package neworangehrm.com.opensourcehrm.steps;

/**
 * Created by Viswa on 12/20/2017.
 */

import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static neworangehrm.com.opensourcehrm.util.DriverUtil.*;
import static neworangehrm.com.opensourcehrm.pages.LoginPage.*;
public class CommonSteps implements En {
    WebDriver driver;

    public CommonSteps() {
        Given("I am on the (.*) page", (String webPage) -> {
            driver = getDriverInstance("chrome");
            driver.get("http://opensource.demo.orangehrmlive.com");
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
