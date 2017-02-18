package ArtificialIntelligence.NaturalLanguageProcessing.FromParagraphsToSentences;

import org.junit.Test;
import testutils.Question;

/**
 * Created by Ferenc on 6/30/2016.
 */
public class SolutionTest {
    @Test
    public void runSolution() throws NoSuchMethodException {
        new Question(Solution.class).testAnswer();
    }
}