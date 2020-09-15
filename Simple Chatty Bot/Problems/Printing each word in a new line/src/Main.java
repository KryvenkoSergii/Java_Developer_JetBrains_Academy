import java.util.Scanner;

class Main {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] words = new String[5];
        words[0] = scanner.next().trim();
        words[1] = scanner.next().trim();
        words[2] = scanner.next().trim();
        words[3] = scanner.next().trim();
        words[4] = scanner.next().trim();

        for (String word : words) {
            System.out.println(word);
        }
    }
}