package tutorials.ten_days_of_statistics.day_0_weighted_mean;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ferenc on 2/18/2016.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> weight = new ArrayList<>();
        //line 1
        int count = sc.nextInt();
        //line 2
        for (int i = 0; i < count; i++) {
            numbers.add(sc.nextInt());
        }
        //line 3
        for (int i = 0; i < count; i++) {
            weight.add(sc.nextInt());
        }

        double nominator = 0;
        double denominator = 0;
        for (int i = 0; i < count; i++) {
            nominator += numbers.get(i) * weight.get(i);
            denominator += weight.get(i);
        }
        double result = nominator / denominator;
        System.out.println(Math.round(result * 10) / 10d);
    }
}