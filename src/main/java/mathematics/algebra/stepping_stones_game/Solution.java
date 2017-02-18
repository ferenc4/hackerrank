package mathematics.algebra.stepping_stones_game;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Ferenc on 6/30/2016.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int games = sc.nextInt();
            if(games > 0) {
                runSimulation(sc);
                for (int i = 1; i < games; i++) {
                    System.out.println();
                    runSimulation(sc);
                }
            }
        }
    }

    private static void runSimulation(Scanner sc) {
        if (sc.hasNextBigInteger()) {
            BigInteger goalBlock = sc.nextBigInteger();
            BigInteger steps = getSteps(goalBlock);
            if (steps.equals(BigInteger.valueOf(-1))) {
                System.out.print("Better Luck Next Time");
            } else {
                System.out.print("Go On Bob " + steps.toString());
            }
        }
    }

    private static BigInteger getSteps(BigInteger goalBlock) {
        BigInteger calcPart = goalBlock
                .multiply(BigInteger.valueOf(8))
                .add(BigInteger.ONE);

        BigInteger root = sqrt(calcPart);
        if (root.multiply(root).equals(calcPart)) {

            BigInteger steps[] = root
                    .subtract(BigInteger.ONE)
                    .divideAndRemainder(BigInteger.valueOf(2));
            if (steps[1].equals(BigInteger.ZERO)) {
                return steps[0];
            } else {
                return BigInteger.valueOf(-1);
            }
        }
        return BigInteger.valueOf(-1);
    }

    private static BigInteger sqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength() / 2);
        BigInteger div2 = div;

        // Loop until we hit the same value twice in a row,
        // or keep alternating.
        while (true) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }
}
