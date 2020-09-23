import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantityStudents = scanner.nextInt();
        int numbersA = 0;
        int numbersB = 0;
        int numbersC = 0;
        int numbersD = 0;
        //
        for (int i = 0; i < quantityStudents; i++) {
            int number = scanner.nextInt();
            if (number == 5) {
                numbersA++;
            } else if (number == 4) {
                numbersB++;
            } else if (number == 3) {
                numbersC++;
            } else if (number == 2) {
                numbersD++;
            }
        }
        //
        System.out.print(numbersD + " ");
        System.out.print(numbersC + " ");
        System.out.print(numbersB + " ");
        System.out.println(numbersA);
    }
}