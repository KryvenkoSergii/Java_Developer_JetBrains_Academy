import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //
        String[] numbers = scanner.nextLine().split(" ");
        int shift = scanner.nextInt();
        //
        method1(numbers, shift);
        method2(numbers, shift);
        method3(numbers, shift);
    }

    private static void method1(String[] array, int shift) {
        System.out.println("method1");
        if (shift >= array.length) {
            shift = shift % array.length;
        }
        String[] res = new String[array.length];
        //
        if (shift != 0) {
            for (int i = 0; i < array.length; i++) {
                if (i + shift < array.length) {
                    res[i + shift] = array[i];
                } else if (i + shift >= array.length) {
                    res[i + shift - array.length] = array[i];
                }
            }
        }
        //
        for (String num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void method2(String[] array, int shift) {
        System.out.println("method2");
        String[] res = new String[array.length];
        //
        if (shift >= array.length) {
            shift = shift % array.length;
        }
        //
        System.arraycopy(array, 0, res, shift, array.length - shift);
        System.arraycopy(array, array.length - shift, res, 0, shift);
        //
        for (String num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void method3(String[] array, int shift) {
        System.out.println("method3");
        List<String> str = Arrays.asList(array);
        Collections.rotate(str, shift);
        str.forEach(element -> System.out.print(element + " "));
        System.out.println();
    }
}