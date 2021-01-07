import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String[] date = new Scanner(System.in).nextLine().split("-"); // YYYY-MM-DD
        System.out.printf("%s/%s/%s", date[1], date[2], date[0]);
    }
}