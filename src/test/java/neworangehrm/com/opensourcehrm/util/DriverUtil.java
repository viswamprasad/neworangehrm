package neworangehrm.com.opensourcehrm.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Viswa on 12/21/2017.
 */

public class DriverUtil {

    String browser = System.getProperty("browser", "chrome");

    public WebDriver getDriverInstance() {

        switch (browser.toLowerCase()) {

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
                return new ChromeDriver();

            default:
                System.out.println("Invalid browser type: " + browser);
                System.exit(1);
                return null;
        }
    }
}