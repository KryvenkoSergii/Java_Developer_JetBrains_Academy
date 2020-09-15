//put imports you need here

import java.util.Scanner;

class Main {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] words = new String[3];
        words[0] = scanner.nextLine().trim();
        words[1] = scanner.nextLine().trim();
        words[2] = scanner.nextLine().trim();

        for (int i = words.length - 1; i >= 0; i--) {
            System.out.println(words[i]);
        }
    }
}