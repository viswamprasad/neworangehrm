package neworangehrm.com.opensourcehrm.steps;

import cucumber.api.java8.En;
import neworangehrm.com.opensourcehrm.pages.CommonWebPage;
import neworangehrm.com.opensourcehrm.pages.UserManagementPage;
import neworangehrm.com.opensourcehrm.pages.WebPage;
import neworangehrm.com.opensourcehrm.util.DriverUtil;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 * Created by Viswa on 12/25/2017.
 */
public class UserManagementSteps implements En {
    DriverUtil driverUtil = new DriverUtil();
    WebDriver driver = driverUtil.getDriverInstance();
    ArrayList<String> menuList=new ArrayList<String>();
    CommonWebPage commonWebPage = new UserManagementPage();

    public UserManagementSteps() {
        When("^I select Admin -> User Management -> Users -> Add for \"([^\"]*)\"$", (String testCaseName) -> {
            commonWebPage.menuNavigation(driver, testCaseName);
//            menuList.add("admin");
//            menuList.add("usermanagement");
//            menuList.add("users");
//            pageActions.menuClick(driver, menuList);
//            pageActions.buttonClick(driver, "add");
        });
        Then("^(.*) is displayed for \"([^\"]*)\"$", (String someElement, String testCaseName) -> {
            Assert.assertTrue("Failed to find " + someElement, commonWebPage.isElementDisplayed(driver, testCaseName, someElement));

        });
    }
}
