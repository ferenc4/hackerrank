import java.util.Scanner;

/**
 * Created by Ferenc on 6/30/2016.
 */
public class TemplateSolution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int tests = sc.nextInt();
            for (int i = 0; i < tests; i++) {
                run(sc);
            }
        }
    }

    public static void run(Scanner sc) {
    }
}
