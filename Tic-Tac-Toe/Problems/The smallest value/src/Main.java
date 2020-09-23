import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        long factorial = 1;
        for (int n = 1; n < Integer.MAX_VALUE; n++) {
            factorial *= (long) n;
            if (factorial > m) {
                System.out.println(n);
                break;
            }
        }
    }
}