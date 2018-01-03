package neworangehrm.com.opensourcehrm.testdatapojos;

/**
 * Created by Viswa on 12/30/2017.
 */
public class TestCase {
    private String name;
    private TestInput testInput;
    private TestOutput testOutput;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestInput getTestInput() {
        return testInput;
    }

    public void setTestInput(TestInput testInput) {
        this.testInput = testInput;
    }

    public TestOutput getTestOutput() {
        return testOutput;
    }

    public void setTestOutput(TestOutput testOutput) {
        this.testOutput = testOutput;
    }
}
