package neworangehrm.com.opensourcehrm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataUtil {
    public static Properties readProperties = new Properties();

    static {
        try {
            readProperties.load(new FileInputStream("src/test/resources/testenv.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String baseUrl = System.getProperty("baseUrl", readProperties.getProperty("baseurl"));

}
