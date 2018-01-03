package neworangehrm.com.opensourcehrm.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import neworangehrm.com.opensourcehrm.util.DriverUtil;
import org.openqa.selenium.WebDriver;


/**
 * Created by Viswa on 12/27/2017.
 */
public class AddUserSteps {
    DriverUtil driverUtil = new DriverUtil();
    WebDriver driver = driverUtil.getDriverInstance();

    @And("^I click on Add button$")
    public void iClickOnAddButton() throws Throwable {
    }

    @And("^I fill add user form$")
    public void iFillAddUserForm() throws Throwable {

    }


}
