import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        System.out.println(input.equals(new StringBuilder(input).reverse().toString()) ? "yes" : "no");
    }
}