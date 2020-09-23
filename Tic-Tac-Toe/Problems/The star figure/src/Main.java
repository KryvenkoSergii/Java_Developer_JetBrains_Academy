import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int qElements = scanner.nextInt();
        String[][] matrix = new String[qElements][qElements];
        for (int i = 0; i < qElements; i++) {
            for (int j = 0; j < qElements; j++) {
                if (qElements / 2 != i) {
                    matrix[i][j] = (i == j) || (qElements - i - 1 == j) || (j == qElements / 2) ? "*" : ".";
                } else {
                    matrix[i][j] = "*";
                }
            }
        }
        //
        for (int i = 0; i < qElements; i++) {
            for (int j = 0; j < qElements; j++) {
                System.out.print(matrix[i][j] + " ");
                if (j == qElements - 1) {
                    System.out.println();
                }
            }
        }
    }
}