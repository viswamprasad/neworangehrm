package neworangehrm.com.opensourcehrm.util;

import neworangehrm.com.opensourcehrm.testdatapojos.TestCase;
import org.boon.json.ObjectMapper;
import org.boon.json.ObjectMapperFactory;
import org.openqa.selenium.interactions.SourceType;

import java.io.File;
import java.util.List;

/**
 * Created by Viswa on 12/31/2017.
 */
public class ReadTestCases {
    public static ObjectMapper mapper = new ObjectMapperFactory().create();
    public static List<TestCase> testCases;

    public ReadTestCases(String testDataFileName){
        testCases = mapper.readValue(new File("src/test/resources/testdata/" + testDataFileName + ".json"), List.class, TestCase.class);
    }
    public static List<TestCase> getTestCases() {
        return testCases;
    }

    public static TestCase getTestCase(String testCaseName) throws IllegalAccessException {
        for(TestCase testCase:testCases){
            if (testCase.getName().equalsIgnoreCase(testCaseName))
                return testCase;
        }
        throw new IllegalAccessException("TestCase not found: " + testCaseName);
    }
}
