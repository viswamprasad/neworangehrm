package neworangehrm.com.opensourcehrm.util;

import static java.lang.System.getProperty;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataUtil {
    public static String browser;
    public static String baseUrl;
    public static String screenShotsPath;

    public static String baseUrl = getProperty("baseUrl", "http://opensource.demo.orangehrmlive.com");

    public static void loadProperties() {
        try {
            Properties prop = new Properties();
            File testEnvFile = new File("src/test/resources/testenv.properties");
            prop.load(new FileInputStream(testEnvFile));
            browser = prop.getProperty("browser");
            baseUrl = prop.getProperty("baseurl");
            screenShotsPath = prop.getProperty("screenshotpath");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
