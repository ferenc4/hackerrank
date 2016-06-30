package Mathematics.Algebra.stepping_stones_game;

/**
 * Created by Ferenc on 6/30/2016.
 */

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static BigInteger sqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength() / 2);
        BigInteger div2 = div;

        // Loop until we hit the same value twice in a row,
        // or keep alternating.
        while(true) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }

    public static void main(String[] args) {
        int games = 0;
        Scanner sc = new Scanner(System.in);
        games = sc.nextInt();
        for (int i = 0; i < games; i++) {
            if (sc.hasNextInt()) {
                BigInteger goalBlock = sc.nextBigInteger();
                //m = (sqrt(8n+1) - 1) / 2
                BigInteger calcPart = goalBlock
                        .multiply(BigInteger.valueOf(8))
                        .add(BigInteger.ONE);
                BigInteger steps = sqrt(calcPart);
                if (steps.multiply(steps).equals(calcPart)) {
                    steps = steps
                            .subtract(BigInteger.ONE)
                            .divide(BigInteger.valueOf(2));
                    System.out.println("Go On Bob "+steps.toString());
                } else {
                    System.out.println("Better Luck Next Time");
                }
            }
        }
    }
}
