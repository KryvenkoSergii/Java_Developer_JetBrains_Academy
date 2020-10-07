import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double pi = Math.PI;
        double r2 = Math.pow(scanner.nextDouble(), 2);
        System.out.println(r2 * pi);
    }
}