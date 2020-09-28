import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int side = scanner.nextInt();
        int[][] matrix = new int[side][side];
        //
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        //
        boolean symmetric = true;
        for (int i = 0; i < side && symmetric; i++) {
            for (int j = 0; j < side; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    System.out.println("break" + " i=" + i + " j=" + j);
                    symmetric = false;
                    break;
                }
            }
        }
        System.out.println(symmetric ? "YES" : "NO");
    }
}