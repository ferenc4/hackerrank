package tutorials.ten_days_of_statistics.day_1_interquartile_range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Ferenc on 2/20/2016.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            numbers.add(sc.nextInt());
        }
        for (int i = 0; i < count; i++) {
            Integer frequency = sc.nextInt() - 1;
            Integer current = numbers.get(i);
            for (int j = 0; j < frequency; j++) {
                numbers.add(current);
            }
        }

        Median second = median(numbers);
        Median first = median(new ArrayList<>(numbers.subList(0, second.lastIndexBefore)));
        Median third = median(new ArrayList<>(numbers.subList(second.firstIndexAfter, numbers.size())));

        System.out.println((third.value - first.value) * 10d / 10);
    }

    private static Median median(ArrayList<Integer> numbers) {
        Collections.sort(numbers);
        Double median = null;
        int medianIndex2 = numbers.size() / 2;
        int medianIndex1 = (numbers.size() - 1) / 2;
        int lastIndex;
        int firstIndex;
        if (numbers.size() % 2 == 0) {
            Double first = new Double(numbers.get(medianIndex1));
            Double second = new Double(numbers.get(medianIndex2));
            median = (first + second) / 2;
            lastIndex = medianIndex1 + 1;
            firstIndex = medianIndex2;
        } else {
            lastIndex = medianIndex1;
            firstIndex = medianIndex2 + 1;
            median = new Double(numbers.get(medianIndex2));
        }
        return new Median(median, lastIndex, firstIndex);
    }

    private static class Median {
        Median(Double value, Integer lastIndexBefore, Integer firstIndexAfter) {
            this.value = value;
            this.lastIndexBefore = lastIndexBefore;
            this.firstIndexAfter = firstIndexAfter;
        }

        Double value = 0d;
        Integer lastIndexBefore = 0;
        Integer firstIndexAfter = 0;
    }
}