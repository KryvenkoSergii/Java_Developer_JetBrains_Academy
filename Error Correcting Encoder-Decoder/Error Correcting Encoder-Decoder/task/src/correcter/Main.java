package correcter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int QUANTITY_SYMBOLS_IN_EACH_BLOCK = 3; // input line split into blocks which contains a certain symbols quantity
    public static final int REPEATING = 3; // quantity symbols repeating in each block
    //    public static final String FILE_TO_READ = "./Error Correcting Encoder-Decoder/task/src/send.txt";
//    public static final String FILE_TO_WRITE = "./Error Correcting Encoder-Decoder/task/src/received.txt";
    public static final String FILE_TO_READ = "send.txt";
    public static final String FILE_TO_WRITE = "received.txt";

    public static void main(String[] args) {
//        String input = new Scanner(System.in).nextLine();
//        StringBuilder[] output = splitLineIntoBlocks3Char(input);
//        System.out.println(getStringFromStringBuilderArray(output));
//        System.out.println(getStringFromStringBuilderArray(triplingAllSymbols(output)));
//        System.out.println(getStringFromStringBuilderArray(change1RandomSymbolInEachBlock(triplingAllSymbols(output))));
//        System.out.println(getStringFromStringBuilderArray(output));
        //
        String input = readFile(FILE_TO_READ);
        String output = changeRandomOneBiteInEachByte(input);
//        System.out.println(input);
//        System.out.println(output);
        writeToFile(output);
    }

    public static String readFile(String fileName) {
        File file = new File(FILE_TO_READ);
        try (Scanner sc = new Scanner(file)) {
            return sc.nextLine();
        } catch (FileNotFoundException e) {
            return "-1";
        }
    }

    public static boolean writeToFile(String line) {
        File file = new File(FILE_TO_WRITE);
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(line);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static String changeRandomOneBiteInEachByte(String line) {
        int index = new Random().nextInt(7);
        byte[] bytes = line.getBytes();
        StringBuilder res = new StringBuilder();
//        System.out.println(Arrays.toString(bytes) + " " + index);
//        System.out.println(convertDecNumberToBin(bytes[0]) + " " + convertDecNumberToBin(1 << index) + " " + convertDecNumberToBin(bytes[0] ^ 1 << index));
        for (int i = 0; i < bytes.length; i++) {
            int number = bytes[i];
            int errorNumber = bytes[i] ^ 1 << index;
            bytes[i] = (byte) errorNumber;
        }
        for (byte b : bytes) {
            res.append((char) b);
        }
        return res.toString();
    }

    public static String convertDecNumberToBin(int numberDec) {
        StringBuilder res = new StringBuilder();
        if (Long.toString(numberDec, 2).length() == 8) {
            res.append(Long.toString(numberDec, 2));
        } else {
            for (int i = Long.toString(numberDec, 2).length(); i < 8; i++) {
                res.append("0");
            }
            res.append(Long.toString(numberDec, 2));
        }
        return res.toString();
    }

    public static StringBuilder[] splitLineIntoBlocks3Char(String line) {
        StringBuilder[] blocks = new StringBuilder[line.length() % QUANTITY_SYMBOLS_IN_EACH_BLOCK == 0 ?
                line.length() / QUANTITY_SYMBOLS_IN_EACH_BLOCK :
                line.length() / QUANTITY_SYMBOLS_IN_EACH_BLOCK + 1];
        char[] symbols = line.toCharArray();
        int indexBlock = 0;
        blocks[indexBlock] = new StringBuilder("");
        for (int i = 0; i < symbols.length; i++) {
            blocks[indexBlock].append(symbols[i]);
            if ((i + 1) % QUANTITY_SYMBOLS_IN_EACH_BLOCK == 0 && symbols.length - 1 != i) {
                indexBlock++;
                if (symbols.length > QUANTITY_SYMBOLS_IN_EACH_BLOCK) {
                    blocks[indexBlock] = new StringBuilder("");
                }
            }
        }
        return blocks;
    }

    public static StringBuilder[] change1RandomSymbolInEachBlock(StringBuilder[] blocks) {
        Random random = new Random();
        for (int i = 0; i < blocks.length; i++) {
            int replaceIndex = random.nextInt(blocks[i].length()); // random position
            char errorSymbol = (char) (random.nextInt(57) + 'A'); // random char
            errorSymbol = errorSymbol != blocks[i].charAt(replaceIndex) ? errorSymbol : (char) (errorSymbol + 1);
            blocks[i].setCharAt(replaceIndex, errorSymbol);
        }
        return blocks;
    }

    public static StringBuilder[] triplingAllSymbols(StringBuilder[] blocks) {
        StringBuilder[] triplingSymbLine = new StringBuilder[
                blocks[blocks.length - 1].length() % QUANTITY_SYMBOLS_IN_EACH_BLOCK == 0 ?
                        blocks.length * REPEATING :
                        (blocks.length * REPEATING - QUANTITY_SYMBOLS_IN_EACH_BLOCK + blocks[blocks.length - 1].length())];
        int indexBlock = 0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length(); j++) {
                triplingSymbLine[indexBlock] = new StringBuilder("");
                for (int k = 0; k < REPEATING; k++) {
                    triplingSymbLine[indexBlock].append(blocks[i].charAt(j));
                }
                indexBlock++;
            }
        }
        return triplingSymbLine;
    }

    public static String getStringFromStringBuilderArray(StringBuilder[] array) {
        StringBuilder line = new StringBuilder();
        for (StringBuilder str : array) {
            line.append(str);
        }
        return line.toString();
    }
}
