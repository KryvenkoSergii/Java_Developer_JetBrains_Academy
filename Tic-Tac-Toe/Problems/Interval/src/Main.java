import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        // (−15,12]∪(14,17)∪[19,+∞)
        System.out.println((num > -15 && num <= 12) || (num > 14 && num < 17) || num >= 19 ? "True" : "False");
    }
}