package neworangehrm.com.opensourcehrm.pages;

import neworangehrm.com.opensourcehrm.util.PageUtil;
import neworangehrm.com.opensourcehrm.util.ReadTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import neworangehrm.com.opensourcehrm.util.PageUtil;

/**
 * Created by Viswa on 12/21/2017.
 */
public class LoginPage extends CommonWebPage {

    public By getElementLocator(String elementName) {
        switch (elementName.toLowerCase()) {
            case "username":
                return By.id("txtUsername");
            case "password":
                return By.id("txtPassword");
            case "login":
                return By.id("btnLogin");
            default:
                return super.getElementLocatorForCommon(elementName);
        }
    }

    public void login(WebDriver driver, String testCaseName) {
        int i = 0;
        try {
            testCase = ReadTestCases.getTestCase(testCaseName);
            for (i = 0; i < (testCase.getTestInput().getFormElements().size() - 1); i++) {
                driver.findElement(PageUtil.commonWebPage.getElementLocator(testCase.getTestInput().getFormElements().get(i).getElementName()))
                        .sendKeys(testCase.getTestInput().getFormElements().get(i).getElementValue());
            }
            driver.findElement(PageUtil.commonWebPage.getElementLocator(testCase.getTestInput().getFormElements().get(i).getElementName())).click();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            //TODO: when exception is caught testcase should be marked as failed.
        }
    }

    public void login(WebDriver driver) {
        driver.findElement(PageUtil.commonWebPage.getElementLocator("username")).sendKeys("admin");
        driver.findElement(PageUtil.commonWebPage.getElementLocator("password")).sendKeys("admin");
        driver.findElement(PageUtil.commonWebPage.getElementLocator("login")).click();
        //TODO: Read username and password from common properties
    }
}
