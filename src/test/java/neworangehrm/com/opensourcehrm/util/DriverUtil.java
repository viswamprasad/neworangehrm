package neworangehrm.com.opensourcehrm.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

/**
 * Created by Viswa on 12/21/2017.
 */

public class DriverUtil {

    String browser = getProperty("browser", "chrome");

    public WebDriver getDriverInstance() {

        switch (browser.toLowerCase()) {

            case "chrome":
                setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
                return new ChromeDriver();

            default:
                throw new IllegalStateException("Invalid browser type: " + browser);
        }
    }
}