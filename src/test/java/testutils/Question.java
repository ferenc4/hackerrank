package testutils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Ferenc on 6/30/2016.
 */
public class Question {

    private Method methodToCall;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final String[] args = {"main"};
    private final String testDataFilePath;

    public Question(Class<?> solutionClass) throws NoSuchMethodException {
        Class[] argTypes = new Class[]{String[].class};
        String separator = FileSystems.getDefault().getSeparator();
        testDataFilePath = "src" + separator +
                "test" + separator +
                "resources" + separator +
                solutionClass.getPackage().getName().replace(".", separator) + separator;
        methodToCall = solutionClass.getDeclaredMethod("main", argTypes);
    }

    public void testAnswer() {
        try {
            testAnswerUnsafely();
        } catch (InvocationTargetException | IllegalAccessException | URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    private void testAnswerUnsafely()
            throws IOException, URISyntaxException, InvocationTargetException, IllegalAccessException {
        File folder = new File(testDataFilePath);
        System.out.println("folder = " + folder);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File testDataFile : listOfFiles) {
                String outputTestFileNamePattern = "output(\\d\\d).txt";
                if (testDataFile.isFile() && testDataFile.getName().matches(outputTestFileNamePattern)) {
                    String testId = getTestId(testDataFile.getName());

                    setUpInputStream(testId);
                    setUpOutputStream();

                    methodToCall.invoke(null, (Object) args);
                    doAssertion(testId);

                    cleanUpInputStream();
                    cleanUpOutputStream();
                }
            }
        }
    }

    private void doAssertion(String testId) throws IOException {
        Scanner actual = new Scanner(new String(outContent.toByteArray()));
        Scanner expected = new Scanner(outputFile(testId));
        int line = 0;
        while (actual.hasNextLine() && expected.hasNextLine()) {
            line++;
            assertThat(actual.nextLine())
                    .as("checking line %d in %s", line, outputFileName(testId))
                    .isEqualTo(expected.nextLine());
        }

        assertThat(expected.hasNextLine())
                .as("checking if line %d in %s is missing from System.out", line, outputFileName(testId))
                .isFalse();
        //optional new line at the end of actual
        if (actual.hasNextLine()) {
            line++;
            assertThat(actual.nextLine())
                    .as("checking line %d in System.out", line)
                    .isEmpty();
            assertThat(actual.hasNextLine())
                    .as("checking line %d in %s", line, outputFile(testId).getAbsolutePath())
                    .isFalse();
        }

        System.err.println(getClass().getPackage().getName() + " passed against data (" +
                outputFileName(testId) + "," +
                inputFileName(testId) + ")"
        );
    }

    private String getTestId(String name) {
        return name.replaceAll("\\D+", "");
    }

    private void setUpOutputStream() {
        outContent.reset();
        System.setOut(new PrintStream(outContent));
    }

    private void cleanUpOutputStream() {
        System.setOut(null);
    }

    private void setUpInputStream(String fileId) throws IOException {
        System.setIn(new ByteArrayInputStream(
                Files.readAllBytes(new File(testDataFilePath + inputFileName(fileId)).toPath())
        ));
    }

    private void cleanUpInputStream() {
        System.setIn(null);
    }

    private String inputFileName(String id) {
        return "input" + id + ".txt";
    }

    private String outputFileName(String id) {
        return "output" + id + ".txt";
    }

    private File outputFile(String id) {
        return new File(testDataFilePath + outputFileName(id));
    }

}