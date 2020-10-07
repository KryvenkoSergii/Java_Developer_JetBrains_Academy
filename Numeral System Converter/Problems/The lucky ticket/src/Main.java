import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");
        int firstSum = 0;
        int secondSum = 0;
        int i = 0;
        do {
            firstSum += Integer.parseInt(input[i]);
            secondSum += Integer.parseInt(input[input.length - i - 1]);
            i++;
        } while (i <= 2);
        System.out.println(firstSum == secondSum ? "Lucky" : "Regular");
    }
}