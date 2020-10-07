import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        char[] input = scanner.nextLine().toCharArray();
        int minEuphonious = 0;
        int matchVowels = 0;
        int matchConsonants = 0;
        for (int i = 0; i < input.length; i++) {
            for (char ch : vowels) {
                if (input[i] == ch) {
                    matchVowels++;
                    matchConsonants = 0;
                    break;
                } else {
                    matchConsonants++;
                    matchVowels = matchConsonants == 6 ? 0 : matchVowels;
                }
            }
            if (matchVowels == 3 || matchConsonants == 18) {
                minEuphonious++;
                matchConsonants = matchConsonants == 18 ? 6 : 0;
                matchVowels = matchVowels == 3 ? 1 : 0;
            }
        }
        System.out.println(minEuphonious);
    }
}