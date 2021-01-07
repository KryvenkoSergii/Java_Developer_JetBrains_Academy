import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int k = scanner.nextInt(); // min value
        int n = scanner.nextInt(); // quantity iterations
        float m = scanner.nextFloat(); // our result <= m
        Random random;
        boolean findResult;
        int seed = k;
        do {
            findResult = true;
            random = new Random(seed);
            for (int i = 0; i < n; i++) {
                double randomNumber = random.nextGaussian();
                if (randomNumber > m) {
                    findResult = false;
                    break;
                }
            }
            if (findResult) {
                System.out.println(seed);
            }
            seed++;
        } while (!findResult);
    }
}