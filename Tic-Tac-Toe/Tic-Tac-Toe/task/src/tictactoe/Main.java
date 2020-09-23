package tictactoe;

import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.print("Enter cells: ");
//        String str = scanner.nextLine();
//        //
        String str = "_________";
        int size = getSizeOfSide(str);
        char[][] matrix = changeToMatrix(str, size);
        //
        printGameField(matrix, size);
        //
        if (checkForSequence(str)) {
            //
            boolean winX = false;
            boolean winO = false;
            boolean hasEmptyCell = true;
            //
            char whoIsNext = 'X';
            addCoordinates(matrix, size, whoIsNext);
            printGameField(matrix, size);
            whoIsNext = whoIsNext == 'X' ? 'O' : 'X';
            //
            while (!winX && !winO && hasEmptyCell) {
                addCoordinates(matrix, size, whoIsNext);
                printGameField(matrix, size);
                winX = checkWinForColumn(matrix, size, "X") ||
                        checkWinForRow(matrix, size, "X") ||
                        checkWinForDiagonal(matrix, size, "X");
                winO = checkWinForColumn(matrix, size, "O") ||
                        checkWinForRow(matrix, size, "O") ||
                        checkWinForDiagonal(matrix, size, "O");
                hasEmptyCell = checkForEmptyCells(matrix, size);
                checkResultOfGameAndPrint(winX, winO, hasEmptyCell);
                whoIsNext = whoIsNext == 'X' ? 'O' : 'X';
            }
        }
    }

    public static char[][] addCoordinates(char[][] matrix, int size, char symbol) {
        boolean happyAddOperation = false;
        while (!happyAddOperation) {
            System.out.print("Enter the coordinates: ");
            String str = scanner.nextLine();
            if (str.contains(" ") && str.length() == 3 && str.replaceAll(" ", "").matches("\\d{2}")) {
                int numX = size - Integer.parseInt(str.substring(1).trim());
                int numY = Integer.parseInt(str.substring(0, 1)) - 1;
                if (numX >= 0 && numX < size && numY >= 0 && numY < size) {
                    if (matrix[numX][numY] == '_') {
                        matrix[numX][numY] = symbol;
                        happyAddOperation = true;
                        return matrix;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        happyAddOperation = false;
                        continue;
                    }
                } else {
                    System.out.printf("Coordinates should be from 1 to %s!\n", size);
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
        return matrix;
    }

    public static void checkResultOfGameAndPrint(boolean winX, boolean winO, boolean hasEmptyCell) {
        if (!winX && !winO && !hasEmptyCell) {
            System.out.println("Draw");
        }
        if (winX && !winO) {
            System.out.println("X wins");
        } else if (!winX && winO) {
            System.out.println("O wins");
        } else if (winX && winO) {
            System.out.println("Impossible");
        }
    }

    public static void printGameField(char[][] matrix, int size) {
        System.out.println("---------");
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static int getSizeOfSide(String line) {
        for (int i = 1; i <= line.length(); i++) {
            if (i * i == line.length()) {
                return i;
            }
        }
        throw new IllegalArgumentException("your entering value length wasn't correct");
    }

    public static char[][] changeToMatrix(String line, int size) {
        char[][] matrix = new char[size][size];
        int row = 0;
        int column = 0;
        for (char symb : line.toCharArray()) {
            if (column < size) {
            } else {
                row++;
                column = 0;
            }
            matrix[row][column] = symb;
            column++;
        }
        return matrix;
    }

    public static boolean checkWinForRow(char[][] matrix, int size, String symbol) {
        for (int i = 0; i < size; i++) {
            int match = 0;
            for (int j = 0; j < size; j++) {
                if (symbol.equals(String.valueOf(matrix[i][j]))) {
                    match++;
                }
                if (match == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkWinForColumn(char[][] matrix, int size, String symbol) {
        for (int i = 0; i < size; i++) {
            int match = 0;
            for (int j = 0; j < size; j++) {
                if (symbol.equals(String.valueOf(matrix[j][i]))) {
                    match++;
                }
                if (match == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkWinForDiagonal(char[][] matrix, int size, String symbol) {
        int match = 0;
        for (int i = 0; i < size; i++) {
            if (symbol.equals(String.valueOf(matrix[i][i]))) {
                match++;
            }
            if (match == 3) {
                return true;
            }
        }
        //
        match = 0;
        for (int i = 0; i < size; i++) {
            if (symbol.equals(String.valueOf(matrix[size - 1 - i][i]))) {
                match++;
            }
            if (match == 3) {
                return true;
            }
        }
        //
        return false;
    }

    public static boolean checkForEmptyCells(char[][] matrix, int size) {
        int match = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == ' ' || matrix[i][j] == '_') {
                    match++;
                }

            }
        }
        return match > 0;
    }

    public static boolean checkForSequence(String line) {
        int quantityX = 0;
        int quantityO = 0;
        for (char symb : line.toCharArray()) {
            if ("X".equals(String.valueOf(symb))) {
                quantityX++;
            } else if ("O".equals(String.valueOf(symb))) {
                quantityO++;
            }
        }
        return quantityX + 1 == quantityO || quantityX == quantityO + 1 || quantityX == quantityO;
    }
}
