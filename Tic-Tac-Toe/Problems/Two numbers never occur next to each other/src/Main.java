import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeArray = scanner.nextInt();
        int[] array = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            array[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean res = true;
        //
        for (int i = 0; i < sizeArray; i++) {
            if (i < sizeArray - 1 && (array[i] == n && array[i + 1] == m || array[i + 1] == n && array[i] == m)) {
                res = false;
            }
        }
        //
        System.out.println(res);
    }
}