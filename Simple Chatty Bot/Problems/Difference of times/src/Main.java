import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pastHour = scanner.nextInt();
        int pastMinutes = scanner.nextInt();
        int pastSeconds = scanner.nextInt();
        int presentHour = scanner.nextInt();
        int presentMinutes = scanner.nextInt();
        int presentSeconds = scanner.nextInt();
        //
        System.out.println(((presentHour - pastHour) * 3600) +
                ((presentMinutes - pastMinutes) * 60) +
                (presentSeconds - pastSeconds));
    }
}