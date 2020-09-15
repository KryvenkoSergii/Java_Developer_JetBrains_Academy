import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int height = scanner.nextInt();
//        int feetUpPerDay = scanner.nextInt();
//        int feetDownPerNight = scanner.nextInt();
//        System.out.println((height-feetUpPerDay) % (feetUpPerDay - feetDownPerNight) == 0 ?
//                (height-feetUpPerDay) / (feetUpPerDay - feetDownPerNight) + 1 :
//                (height-feetUpPerDay) / (feetUpPerDay - feetDownPerNight) + 2);
        //
        int height = scanner.nextInt();
        int upFeet = scanner.nextInt();
        int downFeet = scanner.nextInt();
        float distance = upFeet - downFeet;
        System.out.println(Math.round(Math.ceil((height - upFeet) / distance + 1)));
    }
}