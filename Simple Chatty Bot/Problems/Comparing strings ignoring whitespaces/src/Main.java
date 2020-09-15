import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine().trim().replaceAll(" ", "");
        String line2 = scanner.nextLine().trim().replaceAll(" ", "");
        System.out.println(line1.equals(line2));
    }
}