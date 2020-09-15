import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groupe1 = scanner.nextInt();
        int groupe2 = scanner.nextInt();
        int groupe3 = scanner.nextInt();
        //
        int quantityDesks1 = groupe1 % 2 == 0 ? groupe1 / 2 : (groupe1 + 1) / 2;
        int quantityDesks2 = groupe2 % 2 == 0 ? groupe2 / 2 : (groupe2 + 1) / 2;
        int quantityDesks3 = groupe3 % 2 == 0 ? groupe3 / 2 : (groupe3 + 1) / 2;
        //
        System.out.println(quantityDesks1 + quantityDesks2 + quantityDesks3);
    }
}