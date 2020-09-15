//put imports you need here

import java.util.Scanner;

class Main {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String firstName = scanner.nextLine().trim();
        String age = scanner.nextLine().trim();
        String stageOfEducation = scanner.nextLine().trim();
        String yearsOfExperience = scanner.nextLine().trim();
        String cuisinePreference = scanner.nextLine().trim();

        System.out.printf("The form for %s is completed. " +
                "We will contact you if we need a chef that cooks " +
                "%s dishes.", firstName, cuisinePreference);
    }
}