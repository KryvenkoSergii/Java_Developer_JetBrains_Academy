import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        boolean alphabeticalOrder = false;
        //
//        if (inputLine.length() > 0 && !inputLine.matches("\\d*\\s")) {
//            char[] array = inputLine.toCharArray();
//            int i = 0;
//            int numberAscii = array[0];
//            for (char ch : array) {
//                int num = ch;
//                if (numberAscii == num - 1 || i == 0) {
//                    numberAscii = num;
//                    alphabeticalOrder = true;
//                } else {
//                    alphabeticalOrder = false;
//                    break;
//                }
//                i++;
//            }
//        }
        //
        alphabeticalOrder = true;
        char[] array = inputLine.toCharArray();
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1] - 1) {
                alphabeticalOrder = false;
            }
        }
        //
        System.out.println(alphabeticalOrder);
    }
}