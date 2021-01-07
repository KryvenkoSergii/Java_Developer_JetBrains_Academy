import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[4][4];
        for (int i = 0; i < 4; i++) {
            matrix[i] = scanner.next().toCharArray();
        }
        boolean prettyMatrix = true;
        //
        check:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == matrix[i + 1][j] &&
                        matrix[i][j] == matrix[i + 1][j + 1] &&
                        matrix[i][j] == matrix[i][j + 1]) {
                    prettyMatrix = false;
                    break check;
                }
            }
        }
        //
        System.out.println(prettyMatrix ? "YES" : "NO");
    }
}