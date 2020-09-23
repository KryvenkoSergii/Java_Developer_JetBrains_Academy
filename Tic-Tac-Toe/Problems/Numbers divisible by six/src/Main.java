import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        int scan;
        int sum = 0;
        int i = 1;
        do {
            scan = scanner.nextInt();
            if (scan % 6 == 0) sum += scan;
            i++;
        } while (i <= quantity);
        //
        System.out.println("\n" + sum);
    }
}