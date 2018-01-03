package neworangehrm.com.opensourcehrm.pages;

import neworangehrm.com.opensourcehrm.testdatapojos.TestCase;
import neworangehrm.com.opensourcehrm.util.PageUtil;
import neworangehrm.com.opensourcehrm.util.ReadTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Viswa on 1/1/2018.
 */
public abstract class CommonWebPage implements WebPage {
    static TestCase testCase;
    @Override
    public By getElementLocatorForCommon(String elementName) {
        switch (elementName.toLowerCase()) {
            case "username":
                return By.id("txtUsername");
            case "password":
                return By.id("txtPassword");
            case "login":
                return By.id("btnLogin");
            case "adminmenu":
                return By.id("menu_admin_viewAdminModule");
            case "usermanagementsubmenu":
                return By.id("menu_admin_UserManagement");
            case "users":
                return By.id("menu_admin_viewSystemUsers");
            default:
                throw new IllegalStateException("Invalid web element name: " + elementName);
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String testCaseName, String elementName) {
        try {
            testCase = ReadTestCases.getTestCase(testCaseName);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return driver.findElement(PageUtil.commonWebPage.getElementLocator(testCase.getTestOutput().getExpectedElement())).isDisplayed();
    }

    public void menuNavigation(WebDriver driver, String testCaseName) {
        try {
            testCase = ReadTestCases.getTestCase(testCaseName);
            driver.findElement(PageUtil.commonWebPage.getElementLocator(testCase.getTestInput().getMenuNavigation().getMenu())).click();
            driver.findElement(PageUtil.commonWebPage.getElementLocator(testCase.getTestInput().getMenuNavigation().getSubMenu())).click();
            driver.findElement(PageUtil.commonWebPage.getElementLocator(testCase.getTestInput().getMenuNavigation().getMenuItem())).click();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public void buttonClick(WebDriver driver, String btnName) {
        driver.findElement(PageUtil.commonWebPage.getElementLocator(btnName)).click();
    }
}
