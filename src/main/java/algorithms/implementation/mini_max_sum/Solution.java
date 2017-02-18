package algorithms.implementation.mini_max_sum;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Ferenc on 6/30/2016.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger sum = BigInteger.ZERO;
        BigInteger smallest = null;
        BigInteger greatest = null;
        if (sc.hasNextBigInteger()) {
            BigInteger currentNumber = sc.nextBigInteger();
            smallest = currentNumber;
            greatest = currentNumber;
            sum = sum.add(currentNumber);
            while (sc.hasNextBigInteger()) {
                currentNumber = sc.nextBigInteger();
                smallest = currentNumber.min(smallest);
                greatest = currentNumber.max(greatest);
                sum = sum.add(currentNumber);
            }
        }
        System.out.println(sum.subtract(greatest) + " " + sum.subtract(smallest));
    }
}