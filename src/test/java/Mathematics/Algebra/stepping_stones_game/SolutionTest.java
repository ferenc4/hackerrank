package Mathematics.Algebra.stepping_stones_game;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Ferenc on 6/30/2016.
 */
public class SolutionTest {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    final String outputTestFileNamePattern = "output(\\d\\d).txt";

    public void setUpOutputStream() {
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

    File inputFile(String id) {
        return new File(getTestDataFilePath() + "input" + id + ".txt");
    }

    File outputFile(String id) {
        return new File(getTestDataFilePath() + "output" + id + ".txt");
    }

    void runTest(String testId) throws IOException {
        String newLn = System.lineSeparator();
        //run test here
        Solution.main(new String[]{"main"});

        String expected = IOUtils.toString(new FileReader(outputFile(testId)));
        String actual = new String(outContent.toByteArray());
        assertThat(actual).matches(expected + "(" + newLn + ")?");
        System.err.println("matched");
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
                    System.err.println(testId);

                    setUpInputStream(testId);
                    setUpOutputStream();

                    runTest(testId);

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