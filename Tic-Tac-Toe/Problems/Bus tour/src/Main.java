import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int busHeight = scanner.nextInt();
        int quantityBridges = scanner.nextInt();
        for (int i = 1; i <= quantityBridges; i++) {
            int bridgeHeight = scanner.nextInt();
            if (busHeight >= bridgeHeight) {
                System.out.println("Will crash on bridge " + i);
                break;
            } else if (i == quantityBridges) {
                System.out.println("Will not crash");
            }
        }
    }
}