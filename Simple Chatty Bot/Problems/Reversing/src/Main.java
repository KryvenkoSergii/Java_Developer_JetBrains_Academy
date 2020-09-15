import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int digit1 = number / 100;
        int digit2 = (number % 100) / 10;
        int digit3 = number % 10;
        System.out.print(digit3 > 0 ? digit3 : "");
        System.out.print(digit2);
        System.out.println(digit1);
    }
}