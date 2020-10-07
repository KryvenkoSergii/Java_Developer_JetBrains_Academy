import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double g = 9.8d; // gravity
        double p = scanner.nextDouble(); // density of a liquid
        double h = scanner.nextDouble(); // height of a column
        System.out.println(g * p * h);
    }
}