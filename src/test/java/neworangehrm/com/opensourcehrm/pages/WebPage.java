package neworangehrm.com.opensourcehrm.pages;

import org.openqa.selenium.By;

/**
 * Created by Viswa on 1/2/2018.
 */
public interface WebPage {
    public abstract By getElementLocator(String elementName); //We can remove public abstract as it is by default in interface
    public abstract By getElementLocatorForCommon(String elementName); //We can remove public abstract as it is by default in interface
}
