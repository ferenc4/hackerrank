
package Mathematics.Algebra.stepping_stones_game;

/**
 * Created by Ferenc on 6/30/2016.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int games = 0;
        Scanner sc = new Scanner(System.in);
        games = sc.nextInt();
        for (int i = 0; i < games; i++) {
            if (sc.hasNextInt()) {
                long currentBlock = 0;
                long goalBlock = sc.nextInt();
                long stepSize = 1;
                for (; currentBlock < goalBlock; stepSize++) {
                    currentBlock += stepSize;
                }
                if (currentBlock == goalBlock) {
                    System.out.println("Go On Bob " + (stepSize - 1));
                } else {
                    System.out.println("Better Luck Next Time");
                }
            }
        }
    }
}