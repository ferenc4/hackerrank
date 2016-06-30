package Mathematics.Algebra.stepping_stones_game;

/**
 * Created by Ferenc on 6/30/2016.
 */

import java.util.Scanner;

public class Solution2 {
    public static boolean isTriangularNumber(long num) {
        long calc_num = 8 * num + 1;
        long t = (long) Math.sqrt(calc_num);
        return t * t == calc_num;
    }

    public static void main(String[] args) {
        int games = 0;
        Scanner sc = new Scanner(System.in);
        games = sc.nextInt();
        for (int i = 0; i < games; i++) {
            if (sc.hasNextInt()) {
                long goalBlock = sc.nextInt();
                if (isTriangularNumber(goalBlock)) {
                    System.out.println("Go On Bob ");
                } else {
                    System.out.println("Better Luck Next Time");
                }
            }
        }
    }
}
