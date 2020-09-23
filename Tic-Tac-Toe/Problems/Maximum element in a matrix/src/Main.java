import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] res = new int[n][m];
        int rowIndex = 0;
        int columnIndex = 0;
        int max = Integer.MIN_VALUE;
        String[] line = new String[n];
        for (int i = 0; i < n; i++) {
            line = scanner.nextLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                res[i][j] = Integer.parseInt(line[j].trim());
                if (res[i][j] > max) {
                    max = res[i][j];
                    rowIndex = i;
                    columnIndex = j;
                }
            }
        }
        System.out.printf("%s %s", rowIndex, columnIndex);
    }
}