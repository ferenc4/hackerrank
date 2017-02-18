# Purpose
Created to mimic the environment available on hackerrank.com so I can create and store solutions to excercises offline.

# Testing your solutions
### Running a single or multiple tests
Run tests by specifying regex path to your test.
You can run them by specifying all of the packages:

    gradlew clean test -Dtest.single="mathematics/algebra/stepping_stones_game/SolutionTest"

Or you can shorten the path if you want to run all tests in a specific package:

    gradlew clean test -Dtest.single="mathematics/**/SolutionTest"

### Running all tests:

    gradlew clean test

# Test runner 'framework'
The cool stuff is in src/test/java in the testutils.Question.java class.

# Package naming
The packages are named after the topics on hackerrank. All non-alphanumeric characters are turned into underscores.

# Folder structure
* The solutions should be placed under src/main in the appropriate packages
* The tests should be placed under src/test in the appropriate packages
* The test data files should be placed under src/test/resources in the appropriate packages

# Implementation Of Test
The solution class can be called anything, I just happened to call them Solution.java
Just make sure you use that class in your test.

Note that you can create multiple solutions in the same package, and you can test them as well by creating separate tests for them in the same test class.

    public class SolutionTest {
        @Test
        public void runSolution() throws NoSuchMethodException {
            new Question(Solution.class).testAnswer();
        }
    }

# Contribution
Feel free to improve the framework, or the solutions. You can also add more solutions to the same question, if you think they are different enough.

# Improvements
It would be cool to add support for multiple languages.