import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        int number = 1;
        while (number != 0) {
            number = scanner.nextInt();
            max = max > number ? max : number;
        }
        System.out.println(max);
    }
}