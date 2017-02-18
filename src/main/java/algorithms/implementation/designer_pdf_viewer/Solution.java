package algorithms.implementation.designer_pdf_viewer;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Ferenc on 6/30/2016.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> alphabet = new HashMap<>();
        int aAsAscii = (int) 'a';
        for (int i = 0; i < 26; i++) {
            if (sc.hasNextInt()) {
                alphabet.put((char) (aAsAscii + i), sc.nextInt());
            }
        }

        assert sc.hasNext();
        String text = sc.next();
        int tallest = 0;
        for (int i = 0; i < text.length(); i++) {
            tallest = Integer.max(tallest, alphabet.get(text.charAt(i)));
        }
        int area = tallest * text.length();
        System.out.println(area);
    }
}