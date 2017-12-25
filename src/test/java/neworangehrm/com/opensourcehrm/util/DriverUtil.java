package neworangehrm.com.opensourcehrm.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;

import static java.lang.System.setProperty;

/**
 * Created by Viswa on 12/21/2017.
 */

public class DriverUtil {

    static WebDriver driver;
    static DataUtil dataUtil = new DataUtil();

    public synchronized WebDriver getDriverInstance() {
        if(Optional.ofNullable(driver).isPresent())
            return driver;

        switch (dataUtil.browser.toLowerCase()) {
            case "chrome":
                setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
                driver = new ChromeDriver();
        }

        return driver;
    }

    public void clear() {
        driver = null;
    }
}