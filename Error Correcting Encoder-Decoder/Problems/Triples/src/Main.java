import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int size = scanner.nextInt();
        int triple = 0;
        int[] number = new int[size];
        for (int i = 0; i < size; i++) {
            number[i] = scanner.nextInt();
            if (i > 1 && number[i - 1] + 1 == number[i] && number[i - 2] + 1 == number[i - 1]) {
                triple++;
            }
        }
        System.out.println(triple);
    }
}