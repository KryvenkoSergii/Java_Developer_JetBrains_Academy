import java.util.Scanner;

class Main {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] words = new String[8];
        words[0] = scanner.next().trim();
        words[1] = scanner.next().trim();
        words[2] = scanner.next().trim();
        words[3] = scanner.next().trim();
        words[4] = scanner.next().trim();
        words[5] = scanner.next().trim();
        words[6] = scanner.next().trim();
        words[7] = scanner.next().trim();

        for (int i = words.length - 1; i >= 0; i--) {
            System.out.println(words[i]);
        }
    }
}