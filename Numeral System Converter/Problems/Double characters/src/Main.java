import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        for (char ch : input) {
            System.out.printf("%s%s", ch, ch);
        }
        //
//        Arrays.stream(new Scanner(System.in).nextLine().split(""))
//                .forEach(s -> System.out.printf("%s%s", s, s));
    }
}