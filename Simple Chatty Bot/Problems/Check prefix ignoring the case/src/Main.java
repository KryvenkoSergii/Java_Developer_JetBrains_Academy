import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println("J".compareToIgnoreCase(str.substring(0, 1)) == 0);
    }
}