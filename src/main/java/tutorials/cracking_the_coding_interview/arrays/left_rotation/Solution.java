package tutorials.cracking_the_coding_interview.arrays.left_rotation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ferenc on 6/30/2016.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfIntegers = sc.nextInt();
        int numberOfLeftRotations = sc.nextInt() % numberOfIntegers;
        ArrayList<Integer> integers = new ArrayList<>(numberOfIntegers);
        for (int i = 0; i < numberOfIntegers; i++) {
            integers.add(sc.nextInt());
        }
        assert numberOfIntegers == integers.size();

        System.out.print(integers.get(numberOfLeftRotations));
        for (int i = 1; i < numberOfIntegers; i++) {
            int valueAtIndexToBeCopied = (i + numberOfLeftRotations) % numberOfIntegers;
            System.out.print(" " + integers.get(valueAtIndexToBeCopied));
        }
    }
}