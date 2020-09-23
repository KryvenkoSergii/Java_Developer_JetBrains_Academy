import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] array = line.trim().split(" ");
        int[] numbers = new int[array.length];
        for (int i = 0; i < array.length - 1; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }
        //
        boolean ascSorting = true;
        boolean descSorting = true;
        for (int i = 0; i < numbers.length - 2; i++) {
            if (numbers[i] > numbers[i + 1]) {
                ascSorting = false;
                continue;
            } else if (numbers[i] < numbers[i + 1]) {
                descSorting = false;
                continue;
            }
        }
        //
        System.out.println(ascSorting || descSorting);
    }
}