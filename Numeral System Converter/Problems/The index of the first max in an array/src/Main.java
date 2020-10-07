import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int max = 0;
        int index = 0;
        for (int i = 0; i < size; i++) {
            int number = scanner.nextInt();
            if (number > max) {
                max = number;
                index = i;
            }
        }
        System.out.println(index);
    }
}