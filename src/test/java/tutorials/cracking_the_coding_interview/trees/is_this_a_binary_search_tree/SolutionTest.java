package tutorials.cracking_the_coding_interview.trees.is_this_a_binary_search_tree;

import org.junit.Test;
import testutils.Question;

/**
 * Created by Ferenc on 6/30/2016.
 */
public class SolutionTest {
    @Test
    public void runSolutionAgainstTree0() throws NoSuchMethodException {
        new Question(Solution.class)
                .addArguments(new String[]{"0"})
                .limitDataFilesTo("00")
                .useFilesAsInput(false)
                .testSolution();
    }

    @Test
    public void runSolutionAgainstTree1() throws NoSuchMethodException {
        new Question(Solution.class)
                .addArguments(new String[]{"1"})
                .limitDataFilesTo("01")
                .useFilesAsInput(false)
                .testSolution();
    }

    @Test
    public void runSolutionAgainstTree2() throws NoSuchMethodException {
        new Question(Solution.class)
                .addArguments(new String[]{"2"})
                .limitDataFilesTo("02")
                .useFilesAsInput(false)
                .testSolution();
    }
}