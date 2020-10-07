import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean finish = false;
        List<String> array = new ArrayList<>();
        do {
            String line = scanner.nextLine();
            if ("0".equals(line)) {
                finish = true;
                break;
            }
            try {
                int number = Integer.parseInt(line) * 10;
                array.add(String.valueOf(number));
            } catch (Exception e) {
                array.add("Invalid user input: " + line);
            }
        } while (!finish);
        //
        for (String str : array) {
            System.out.println(str);
        }
    }
}