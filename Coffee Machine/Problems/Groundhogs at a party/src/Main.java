import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cups = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();
        if (isWeekend && cups >= 15 && cups <= 25) {
            System.out.println("true");
        } else if (!isWeekend && cups >= 10 && cups <= 20) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}