package neworangehrm.com.opensourcehrm.steps;

/**
 * Created by Viswa on 12/20/2017.
 */

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;

import neworangehrm.com.opensourcehrm.pages.CommonWebPage;
import neworangehrm.com.opensourcehrm.pages.LoginPage;
import neworangehrm.com.opensourcehrm.pages.UserManagementPage;
import neworangehrm.com.opensourcehrm.util.ReadTestCases;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import neworangehrm.com.opensourcehrm.util.DriverUtil;
import neworangehrm.com.opensourcehrm.util.PageUtil;

import static neworangehrm.com.opensourcehrm.util.DataUtil.baseUrl;

public class CommonSteps implements En {

    DriverUtil driverUtil = new DriverUtil();
    WebDriver driver = driverUtil.getDriverInstance();
    PageUtil pageUtil = new PageUtil();
    ReadTestCases readTestCases;

    @Before
    public void setUp() {

        driverUtil = new DriverUtil();
    }
    public CommonSteps() {
        Given("^I am on the \"([^\"]*)\" page$", (String webPage) -> {
            switch(webPage.toLowerCase()){
                case "login":
                    driverUtil.getDriverInstance().get(baseUrl);
                    pageUtil.setCurrentPage("login");
                    break;
                case "dashboard":
                    pageUtil.setCurrentPage("dashboard");
                    break;
                case "usermanagement":
                    pageUtil.setCurrentPage("usermanagement");
                    break;
                default:
                    driverUtil.getDriverInstance().get(baseUrl);
            }

        });

        When("^I fill the login form and submit for \"([^\"]*)\"$", (String testCaseName) -> {
            ((LoginPage) pageUtil.getCurrentPage()).login(driver, testCaseName);
        });

        Then("^The page is displayed$", () -> {
            Assert.assertEquals("Mismatch in page title", "OrangeHRM", driverUtil.getDriverInstance().getTitle());
            //TODO: Expected title should be changed to unique value and it can not be OrangeHRM which is a default value
        });
        Given("^Load TestCases for \"([^\"]*)\"$", (String testCasesFileName) -> {
            readTestCases = new ReadTestCases(testCasesFileName);
        });
        Given("^I am already logged in$", () -> {
            driverUtil.getDriverInstance().get(baseUrl);
            pageUtil.setCurrentPage("login");
            ((LoginPage) pageUtil.getCurrentPage()).login(driver);
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