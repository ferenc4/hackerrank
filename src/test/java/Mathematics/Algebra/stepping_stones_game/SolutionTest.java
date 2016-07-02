package Mathematics.Algebra.stepping_stones_game;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Ferenc on 6/30/2016.
 */
public class SolutionTest {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    ;
    final String outputTestFileNamePattern = "output(\\d\\d).txt";

    public void setUpOutputStream() {
        outContent.reset();
        System.setOut(new PrintStream(outContent));
    }

    public void cleanUpOutputStream() {
        System.setOut(null);
    }

    public void setUpInputStream(String fileId) throws IOException {
        String path = getTestDataFilePath();
        System.setIn(new ByteArrayInputStream(
                FileUtils.readFileToByteArray(inputFile(fileId))
        ));
    }

    public void cleanUpInputStream() {
        System.setIn(null);
    }

    String inputFileName(String id) {
        return "input" + id + ".txt";
    }

    File inputFile(String id) {
        return new File(getTestDataFilePath() + inputFileName(id));
    }

    String outputFileName(String id) {
        return "output" + id + ".txt";
    }

    File outputFile(String id) {
        return new File(getTestDataFilePath() + outputFileName(id));
    }

    void doAssertion(String testId) throws IOException {
        String newLn = System.lineSeparator();

        Solution.main(new String[]{"main"});

        Scanner actual = new Scanner(new String(outContent.toByteArray()));
        Scanner expected = new Scanner(outputFile(testId));
        int line = 0;
        while (actual.hasNextLine() && expected.hasNextLine()) {
            line++;
            assertThat(actual.nextLine())
                    .as("checking line %d in %s", line, outputFile(testId).getAbsolutePath())
                    .isEqualTo(expected.nextLine());
        }
        if (actual.hasNextLine() && !expected.hasNextLine()) {
            assertThat(actual.nextLine()).isEmpty();
            assertThat(actual.hasNextLine()).isFalse();
        }
        System.err.println(getClass().getPackage().getName() + " passed against data (" +
                outputFileName(testId) + "," +
                inputFileName(testId) + ")"
        );
    }

    String getTestId(String name) {
        return name.replaceAll("\\D+", "");
    }

    @Test
    public void main() throws IOException, URISyntaxException {
        String separator = FileSystems.getDefault().getSeparator();
        String path = getTestDataFilePath();
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File testDataFile : listOfFiles) {
                if (testDataFile.isFile() && testDataFile.getName().matches(outputTestFileNamePattern)) {
                    String testId = getTestId(testDataFile.getName());

                    setUpInputStream(testId);
                    setUpOutputStream();

                    doAssertion(testId);

                    cleanUpInputStream();
                    cleanUpOutputStream();
                }
            }
        }
    }

    public String getTestDataFilePath() {
        String separator = FileSystems.getDefault().getSeparator();
        return "src" + separator +
                "test" + separator +
                "resources" + separator +
                getClass().getPackage().getName().replace(".", separator) + separator;
    }
}