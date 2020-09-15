import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cityName = scanner.nextLine();
        int strLength = cityName.length();
        if (strLength > 4) {
            System.out.println(cityName.substring(strLength - 4, strLength).contains("burg"));
        } else {
            System.out.println("false");
        }
    }
}