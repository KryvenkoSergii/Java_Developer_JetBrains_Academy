import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int durationInDays = scanner.nextInt();
        int totalFoodCostPerDay = scanner.nextInt();
        int oneWayFlightCost = scanner.nextInt();
        int costOfOneNightInHotel = scanner.nextInt();
        int spendForOneDay = totalFoodCostPerDay + costOfOneNightInHotel;
        System.out.println((oneWayFlightCost * 2) + (spendForOneDay * durationInDays - costOfOneNightInHotel));
    }
}