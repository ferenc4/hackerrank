Feature: Finding the greatest decent number for a given size

  Sherlock Holmes suspects his archenemy, Professor Moriarty, is once again plotting something diabolical.
  Sherlock's companion, Dr. Watson, suggests Moriarty may be responsible for MI6's recent issues with their
  supercomputer, The Beast.

  Shortly after resolving to investigate, Sherlock receives a note from Moriarty boasting about infecting The Beast
  with a virus; however, he also gives him a clue—a number, N. Sherlock determines the key to removing the virus is
  to find the largest Decent Number having N digits.

  A Decent Number has the following properties:
  Its digits can only be 3's and/or 5's.
  The number of 3's it contains is divisible by 5.
  The number of 5's it contains is divisible by 3.
  If there are more than one such number, we pick the largest one.
  Moriarty's virus shows a clock counting down to The Beast's destruction, and time is running out fast. Your task is
  to help Sherlock find the key before The Beast is destroyed!

  Constraints
  1≤T≤201≤T≤20
  1≤N≤1000001≤N≤100000


  Input Format
  The first line is an integer, T, denoting the number of test cases.
  The T subsequent lines each contain an integer, N, detailing the number of digits in the number.

  Output Format
  Print the largest Decent Number having N digits; if no such number exists, tell Sherlock by printing -1.

  Sample Input
  4
  1
  3
  5
  11

  Sample Output
  -1
  555
  33333
  55555533333

  Explanation
  For N=1, there is no decent number having 1 digit (so we print −1).
  For N=3, 555 is the only possible number. The number 5 appears three times in this number, so our count of
  5's is evenly divisible by 3 (Decent Number Property 3).
  For N=5, 33333 is the only possible number. The number 3 appears five times in this number, so our count
  of 3's is evenly divisible by 5 (Decent Number Property 2).
  For N=11, 55555533333 and all permutations of these digits are valid numbers; among them, the given
  number is the largest one.

  Scenario Outline: Finding the greatest decent number with rule
    When I enter size <size>
    Then the output is a decent number containing only the digits 3 and 5
    And the number of 5s in the output is divisible by 3
    And the number of 3s in the output is divisible by 5
    Examples:
      | size |
      | 3    |
      | 5    |
      | 11   |

  Scenario Outline: Finding the greatest decent number with example
    When I enter size <size>
    Then the output is <decent number>
    Examples:
      | size | decent number        |
#      | -99  | -1                   |
#      | 1    | -1                   |
#      | 4    | -1                   |
      | 3    | 555                  |
      | 5    | 33333                |
      | 11   | 55555533333          |
 #     | 2000 | largeNumber2000 |

#  Scenario: Finding the greatest decent number with a large size
#
#  Scenario: Finding the greatest decent number under the time limit
