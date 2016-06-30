package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.*;
import java.util.Scanner;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by Ferenc on 3/14/2016.
 */
public class GreatestDecentNumberStepDefs {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @When("^I enter size (\\d+)$")
    public void iEnterSizeSize(int size) throws Throwable {
        GreatestDecentNumber gdn = new GreatestDecentNumber();
        gdn.findComponents(size);
        gdn.printResult();
    }

    @Then("^the output is (\\w+)$")
    public void theOutputIsDecentNumber(String expected) throws Throwable {
        try {
            Integer.parseInt(expected);
            assertEquals(expected, outContent.toString());
        } catch (NumberFormatException e) {
            assertTrue(false);
            InputStream inputStream = getClass().getResourceAsStream("/" + expected);
            BufferedInputStream bs = new BufferedInputStream(inputStream);
            Scanner scanner = new Scanner(bs);
            byte[] actual = outContent.toByteArray();
            int current = 0;
            while (scanner.hasNext()) {
                String nextChar = scanner.next();
                Assert.assertEquals(nextChar, String.valueOf(actual[current++]));
            }
        }
    }

    @Then("^the output is a decent number containing only the digits (\\d+) and (\\d+)$")
    public void theOutputIsADecentNumberContainingOnlyTheDigitsAnd(char num1, char num2) throws Throwable {
        String output = outContent.toString();
        int outputSize = output.length();
        for(int i = 0; i < outputSize; i++){
            if(num1 != output.charAt(i) && num2 != output.charAt(i)){
                throw new Exception("Invalid digit at "+i+" in output number. expected <"+num1+"> OR <"+num2+"> but was <"+output.charAt(i)+">");
            }
        }
    }

    @And("^the number of (\\d+)s in the output is divisible by (\\d+)$")
    public void theNumberOfSInTheOutputIsDivisibleBy(char num1, int num2) throws Throwable {
        String output = outContent.toString();
        int outputSize = output.length();
        int num1Count = 0;
        for (int i = 0; i < outputSize; i++) {
            if (num1 == output.charAt(i)) {
                num1Count++;
            }
        }
        Assert.assertTrue(num1Count % num2 == 0);
    }
}
