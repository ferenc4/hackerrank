package artificial_intelligence.natural_language_processing.from_paragraphs_to_sentences;

import org.junit.Test;
import testutils.Question;

/**
 * Created by Ferenc on 6/30/2016.
 */
public class SolutionTest {
    @Test
    public void runSolution() throws NoSuchMethodException {
        new Question(Solution.class).testSolution();
    }
}