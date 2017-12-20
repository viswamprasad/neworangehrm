package neworangehrm.com.opensourcehrm.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Viswa on 12/21/2017.
 */

public class DriverUtil {
    public static WebDriver getDriverInstance(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
                return new ChromeDriver();

            default:
                System.out.println("Invalid Browser Type...");
                return null;
        }

    }
}
