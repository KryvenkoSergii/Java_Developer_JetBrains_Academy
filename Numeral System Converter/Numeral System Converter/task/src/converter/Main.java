package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] number = readInputNumbers();
        System.out.println(isEnteredNumbersRight(number) ?
                converter(number[1], number[0], number[2]) :
                "error");
    }

    public static String[] readInputNumbers() {
        Scanner scanner = new Scanner(System.in);
        String[] number = new String[3]; // [0] - radixSource, [1] - numberSource, [2] - radixTarget
        int i = 0;
        do {
            number[i++] = scanner.next();
        } while (i < 3 && scanner.hasNext());
        scanner.close();
        return number;
    }

    public static boolean isEnteredNumbersRight(String[] numbers) {
        if (isRadixCorrect(numbers[0]) && isRadixCorrect(numbers[2]) && numbers.length == 3) {
            return isSourceNumberRight(numbers[1], numbers[0]);
        }
        return false;
    }

    public static boolean isSourceNumberRight(String numberSource, String radixSource) {
        if (isRadixCorrect(radixSource)) {
            int radix = Integer.parseInt(radixSource);
            for (char ch : numberSource.toCharArray()) {
                if (ch != '0' && ch != '.' &&
                        convertNumberToDec(String.valueOf(ch), 36) > radix) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isRadixCorrect(String number) {
        if (number == null || number.equals("0")) {
            return false;
        } else if (number.matches("\\d*")) {
            int radix = Integer.parseInt(number);
            return radix < 37 && radix > 0 ? true : false;
        }
        return false;
    }

    public static String converter(String numberSource, String radixS, String radixT) {
        int radixSource = Integer.parseInt(radixS);
        int radixTarget = Integer.parseInt(radixT);
        if (numberSource.contains(".")) {
            StringBuilder res = new StringBuilder();
            String[] split = splitInputLine(numberSource);
            res.append(convertDecNumber(convertNumberToDec(split[0], radixSource), radixTarget));
            res.append(".");
            res.append(convertFractionalDecToTargetRadix(convertFractionalToDec(split[1], radixSource), radixTarget));
            return res.toString();
        }
        return convertDecNumber(convertNumberToDec(numberSource, radixSource), radixTarget);
    }

    public static String convertDecNumber(int numberDec, int radix) {
        if (radix == 1) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < numberDec; i++) {
                res.append("1");
            }
            return res.toString();
        }
        return Long.toString(numberDec, radix);
    }

    public static int convertNumberToDec(String number, int radix) {
        if (radix == 1) {
            return number.split("").length;
        }
        return Integer.parseInt(number, radix);
    }

    public static String[] splitInputLine(String input) {
        return input.trim().split("\\.");
    }

    public static double convertFractionalToDec(String number, int radix) {
        double num = 0;
        String[] split = number.split("");
        for (int i = 0; i < split.length; i++) {
            num += Integer.parseInt(split[i], radix) / (Math.pow(radix, i + 1));
        }
        return num;
    }

    public static String convertFractionalDecToTargetRadix(double number, int radixTarget) {
        StringBuilder fractPart = new StringBuilder(5);
        double n1 = number * radixTarget;
        for (int i = 0; i < 5; i++) {
            int n2 = (int) n1;
            fractPart.append(String.valueOf(convertDecNumber(n2, radixTarget)));
            n1 = (n1 - n2) * radixTarget;
        }
        return fractPart.toString();
    }
}
