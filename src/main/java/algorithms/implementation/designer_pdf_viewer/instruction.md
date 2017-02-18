When you select a contiguous block of text in a PDF viewer, the selection is highlighted with a blue rectangle. In a new kind of PDF viewer, the selection of each word is independent of the other words; this means that each rectangular selection area forms independently around each highlighted word. For example:

![Pdf highlighting](PDF-highighting.png)

In this type of PDF viewer, the width of the rectangular selection area is equal to the number of letters in the word times the width of a letter, and the height is the maximum height of any letter in the word.

Consider a word consisting of lowercase English alphabetic letters, where each letter is 1mm wide. Given the height of each letter in millimeters (mm), find the total area that will be highlighted by blue rectangle in mm<sup>2</sup> when the given word is selected in our new PDF viewer.

Input Format

The first line contains 26 space-separated integers describing the respective heights of each consecutive lowercase English letter (i.e.h<sub>a</sub>, h<sub>b</sub>, h<sub>c</sub>,...,h<sub>y</sub>,h<sub>z</sub>). 
The second line contains a single word, consisting of lowercase English alphabetic letters.

# Constraints

* 1 <= h<sub>?</sub> <= 7, where ? is an English lowercase letter.
* Word contains no more than  letters.
# Output Format

Print a single integer denoting the area of highlighted rectangle when the given word is selected. The unit of measurement for this is square millimeters (), but you must only print the integer.

# Sample Input

    1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5
    abc
# Sample Output

    9
# Explanation

We are highlighting the word abc:

The tallest letter in abc is b, and h<sub>b</sub> = 3. The selection area for this word is 3 * 1mm * 3mm = 9mmh<sup>2</sup>.
# Note: Recall that the width of each character is 1mm.