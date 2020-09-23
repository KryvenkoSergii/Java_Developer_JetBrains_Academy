import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        String[] vowels = {"a", "i", "e", "o", "u"};
        String symbol = String.valueOf(ch);
        for (String vowel : vowels) {
            if (vowel.equalsIgnoreCase(symbol)) {
                return true;
            }
        }
        return false;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}