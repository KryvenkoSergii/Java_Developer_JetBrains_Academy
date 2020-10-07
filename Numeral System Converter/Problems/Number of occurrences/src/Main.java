import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String occurrence = scanner.nextLine();
        Pattern p = Pattern.compile(occurrence);
        Matcher m = p.matcher(input);
        int matches = 0;
        while (m.find()) {
            matches++;
        }
        System.out.println(matches);
    }
}