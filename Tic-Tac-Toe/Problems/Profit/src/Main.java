import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double m = scanner.nextDouble();
        double p = scanner.nextDouble();
        double k = scanner.nextDouble();

        if (k == m) {
            System.out.println("0");
        } else {
            for (int i = 1; k >= m; i++) {
                m *= p / 100 + 1;
                if (k <= m) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
