package neworangehrm.com.opensourcehrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataUtil {

    public static String browser;
    public static String baseUrl;

    public DataUtil() {
        try {
            Properties prop = new Properties();
            File testEnvFile = new File("src/test/resources/testenv.properties");
            prop.load(new FileInputStream(testEnvFile));
            browser = prop.getProperty("browser");
            baseUrl = prop.getProperty("baseurl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
