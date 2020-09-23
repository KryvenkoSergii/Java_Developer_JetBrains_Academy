import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int average = 0;
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number == 0) {
                System.out.println(average);
                break;
            }
            average += number;
            if (average >= 1000) {
                System.out.println(average - 1000);
                break;
            }
        }
    }
}