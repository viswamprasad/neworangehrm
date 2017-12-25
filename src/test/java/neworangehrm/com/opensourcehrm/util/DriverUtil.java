package neworangehrm.com.opensourcehrm.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

/**
 * Created by Viswa on 12/21/2017.
 */

public class DriverUtil {
    public static String browser = getProperty("browser", "chrome");
    public static WebDriver driver;
    static {
        switch (browser.toLowerCase()) {
            case "chrome":
                setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
                driver = new ChromeDriver();
        }
    }
    public WebDriver getDriverInstance() {
            return driver;
    }
}