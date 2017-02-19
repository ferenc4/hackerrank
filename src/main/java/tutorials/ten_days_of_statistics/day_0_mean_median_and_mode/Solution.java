package tutorials.ten_days_of_statistics.day_0_mean_median_and_mode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by Ferenc on 2/18/2016.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int NUMBER_COUNT = sc.nextInt();
        TreeMap<BigInteger, Integer> occurrences = new TreeMap<>();
        ArrayList<BigInteger> numbers = new ArrayList<>();
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            BigInteger bigInteger = sc.nextBigInteger();
            sum = sum.add(bigInteger);
            numbers.add(bigInteger);
            if (!occurrences.containsKey(bigInteger)) {
                occurrences.put(bigInteger, 1);
            } else {
                occurrences.put(bigInteger, occurrences.get(bigInteger) + 1);
            }
        }

        //mean
        mean(NUMBER_COUNT, sum);
        //median
        median(NUMBER_COUNT, numbers);
        //mode
        mode(occurrences);
    }

    private static void mode(TreeMap<BigInteger, Integer> occurrences) {
        int max = 0;
        BigInteger mode = null;
        for (Map.Entry<BigInteger, Integer> value : occurrences.entrySet()) {
            Integer currentCount = value.getValue();
            if (max < currentCount) {
                max = currentCount;
                mode = value.getKey();
            }
        }
        if (mode != null) {
            System.out.println(mode.toString());
        }
    }

    private static void mean(int NUMBER_COUNT, BigInteger sum) {
        System.out.println(new BigDecimal(sum).divide(BigDecimal.valueOf(NUMBER_COUNT)).toString());
    }

    private static void median(int NUMBER_COUNT, ArrayList<BigInteger> numbers) {
        Collections.sort(numbers);
        BigDecimal median = null;
        if (NUMBER_COUNT % 2 == 0) {
            BigDecimal first = new BigDecimal(numbers.get(NUMBER_COUNT / 2 - 1));
            BigDecimal second = new BigDecimal(numbers.get(NUMBER_COUNT / 2));
            median = first
                    .add(second)
                    .divide(new BigDecimal(2));
        } else {
            median = new BigDecimal(numbers.get(NUMBER_COUNT / 2));
        }

        System.out.println(median.toString());
    }
}