import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().trim().split(" ");
        long firstNumber = Long.parseLong(array[0]);
        long secondNumber = Long.parseLong(array[2]);
        switch (array[1].charAt(0)) {
            case '+':
                System.out.println(firstNumber + secondNumber);
                break;
            case '-':
                System.out.println(firstNumber - secondNumber);
                break;
            case '/':
                System.out.println(secondNumber != 0 ? firstNumber / secondNumber : "Division by 0!");
                break;
            case '*':
                System.out.println(firstNumber * secondNumber);
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }
    }
}