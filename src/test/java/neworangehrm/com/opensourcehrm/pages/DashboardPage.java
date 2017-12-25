package neworangehrm.com.opensourcehrm.pages;

import org.openqa.selenium.By;

/**
 * Created by Viswa on 12/25/2017.
 */
public class DashboardPage {
    public static By getElementLocator(String elementName){
        switch(elementName.toLowerCase()){
            case "welcomemessage":
                return By.id("welcome");
            default:
                throw new IllegalStateException("Invalid web element name: " + elementName);
        }
    }
}
