import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i * i <= n; i++) {
            System.out.println(i * i);
        }
        //
//        IntStream.iterate(1, i -> i + 1)
//                .map(i -> i * i)
//                .takeWhile(i -> i <= n)
//                .forEach(System.out::println);
    }
}