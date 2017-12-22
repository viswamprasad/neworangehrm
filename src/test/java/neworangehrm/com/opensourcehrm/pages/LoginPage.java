package neworangehrm.com.opensourcehrm.pages;

import org.openqa.selenium.By;

/**
 * Created by Viswa on 12/21/2017.
 */
public class LoginPage {

    public static By getElementLocator(String elementName) {

        switch (elementName.toLowerCase()) {

            case "username":
                return By.id("txtUsername");
            case "password":
                return By.id("txtPassword");
            case "login":
                return By.id("btnLogin");
            default:
                throw new IllegalStateException("Invalid web element name: " + elementName);
        }
    }
}
