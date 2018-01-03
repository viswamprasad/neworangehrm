package neworangehrm.com.opensourcehrm.pages;

import org.openqa.selenium.By;

/**
 * Created by Viswa on 12/25/2017.
 */
public class UserManagementPage extends CommonWebPage {
    public By getElementLocator(String elementName) {
        switch(elementName.toLowerCase()){
            case "addbutton":
                return By.id("btnAdd");
            case "userheading":
                return By.id("UserHeading");
            default:
                return super.getElementLocatorForCommon(elementName);
                //throw new IllegalStateException("Invalid web element name: " + elementName);
        }
    }
}
