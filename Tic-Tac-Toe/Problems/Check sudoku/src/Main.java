import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int sizeSquare = size * size;
        int[][] matrix = new int[sizeSquare][sizeSquare];
        //
        for (int i = 0; i < sizeSquare; i++) {
            for (int j = 0; j < sizeSquare; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        //
        boolean solvedSudoku = false;
        if (matrix[0].length == 1) {
            solvedSudoku = matrix[0][0] == 1 ? true : false;
        } else {
            solvedSudoku = checkForSquares(matrix, size, sizeSquare) && checkCross(matrix, size, sizeSquare);
        }
        //
        System.out.println(solvedSudoku ? "YES" : "NO");
    }

    public static boolean checkForSquares(int[][] matrix, int size, int sizeSquare) {
        boolean res = false;
        int nextRow = 0;
        for (int i = 0; i <= size; i++) {
            int[] array = new int[sizeSquare];
            int sum = 0;
            int p = 0;
            nextRow += (i == size) ? 1 : 0;
            i = i == size ? 0 : i;
            for (int j = nextRow * size; j < size * nextRow + size; j++) {
                for (int k = i * size; k < size * i + size; k++) {
                    array[p] = matrix[j][k];
                    sum += matrix[j][k];
                    p++;
                }
            }
            if (!checkArrayForRepetition(array) && sum == arithmeticProgression(sizeSquare)) {
                res = true;
            }
            if (nextRow == size - 1 && i == size - 1) {
                break;
            }
        }
        return res;
    }

    public static boolean checkCross(int[][] matrix, int size, int sizeSquare) {
        int[] arrayRow = new int[sizeSquare];
        int[] arrayColumn = new int[sizeSquare];
        for (int i = 0; i < sizeSquare; i++) {
            int p = 0;
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < sizeSquare; j++) {
                arrayRow[p] = matrix[i][j];
                arrayColumn[p] = matrix[j][i];
                p++;
                sum1 += matrix[i][j];
                sum2 += matrix[j][i];
            }
            if (checkArrayForRepetition(arrayRow) || sum1 != arithmeticProgression(sizeSquare) ||
                    checkArrayForRepetition(arrayColumn) || sum2 != arithmeticProgression(sizeSquare)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkArrayForRepetition(int[] array) {
        for (int elementArray : array) {
            int match = 0;
            for (int j = 1; j <= array.length; j++) {
                if (elementArray == j) {
                    match++;
                }
            }
            if (match > 1) {
                return true;
            }
        }
        return false;
    }

    public static int arithmeticProgression(int sizeSquare) {
        int res = 0;
        for (int i = 1; i <= sizeSquare; i++) {
            res += i;
        }
        return res;
    }
}