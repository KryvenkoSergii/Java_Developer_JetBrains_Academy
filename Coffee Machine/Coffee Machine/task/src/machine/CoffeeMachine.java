package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        boolean exit = false;
        Machine machine = new Machine(400, 540, 120, 9, 550);
        do {
            machine.getAction();
            exit = machine.getState().equals(CoffeeMachineState.EXIT);
        } while (!exit);
    }
}

class Machine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;
    private CoffeeMachineState state;
    private KindOfCoffee kindOfCoffee;
    private Scanner scanner;

    public Machine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
        this.state = CoffeeMachineState.PENDING;
        this.scanner = new Scanner(System.in);
    }

    public void getAction() {
        if (this.state.equals(CoffeeMachineState.PENDING)) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String input = scanner.nextLine().trim();
            this.state = CoffeeMachineState.BUSY;
            switch (input) {
                case "buy":
                    actionBuy();
                    break;
                case "fill":
                    loadResources();
                    System.out.println();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    System.out.println();
                    printResources();
                    break;
                case "exit":
                    this.state = CoffeeMachineState.EXIT;
                    break;
                default:
                    this.state = CoffeeMachineState.EXIT;
                    break;
            }
        } else {
            System.out.println("CoffeeMachine " + state.getState());
        }
    }

    private void printResources() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of %s\n", water, "water");
        System.out.printf("%d of %s\n", milk, "milk");
        System.out.printf("%d of %s\n", coffeeBeans, "coffee beans");
        System.out.printf("%d of %s\n", disposableCups, "disposable cups");
        System.out.printf("%d of %s\n\n", money, "money");
        this.state = CoffeeMachineState.PENDING;
    }

    private void loadResources() {
        System.out.println("\nWrite how many ml of water do you want to add:");
        this.water += +scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        this.milk += +scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        this.coffeeBeans += +scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        this.disposableCups += +scanner.nextInt();
        scanner.nextLine();
        //
        this.state = CoffeeMachineState.PENDING;
    }

    private void actionBuy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String input = scanner.nextLine().trim();
        if (input.matches(".*\\d.*")) {
            this.kindOfCoffee = KindOfCoffee.findByNumber(input.trim());
            makeCoffee();
        }
        this.state = CoffeeMachineState.PENDING;
    }

    private void makeCoffee() {
        if (checkResourcesBeforeMakeCoffee()) {
            this.water -= kindOfCoffee.getWater();
            this.milk -= kindOfCoffee.getMilk();
            this.coffeeBeans -= kindOfCoffee.getCoffeeBeans();
            this.disposableCups -= kindOfCoffee.getDisposableCups();
            this.money += kindOfCoffee.getCost();
            System.out.println("I have enough resources, making you a coffee!\n");
        } else {
            if (this.water - kindOfCoffee.getWater() < 0) {
                System.out.println("Sorry, not enough water!\n");
            } else if (this.coffeeBeans - kindOfCoffee.getCoffeeBeans() < 0) {
                System.out.println("Sorry, not enough coffee beans!\n");
            } else if (this.milk - kindOfCoffee.getMilk() < 0) {
                System.out.println("Sorry, not enough milk!\n");
            } else if (this.disposableCups - kindOfCoffee.getDisposableCups() < 0) {
                System.out.println("Sorry, not enough disposable cups!\n");
            }
        }
    }

    private boolean checkResourcesBeforeMakeCoffee() {
        return this.water - kindOfCoffee.getWater() >= 0 &&
                this.milk - kindOfCoffee.getMilk() >= 0 &&
                this.coffeeBeans - kindOfCoffee.getCoffeeBeans() >= 0 &&
                this.disposableCups - kindOfCoffee.getDisposableCups() >= 0 ?
                true : false;
    }

    private void takeMoney() {
        System.out.printf("\nI gave you $%d\n\n", money);
        this.money = 0;
        this.state = CoffeeMachineState.PENDING;
    }

    public CoffeeMachineState getState() {
        return state;
    }
}

enum CoffeeMachineState {
    PENDING("pending"),
    BUSY("busy"),
    EXIT("exit");

    String state;

    CoffeeMachineState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

enum KindOfCoffee {
    ESPRESSO("1", 250, 0, 16, 1, 4),
    LATTE("2", 350, 75, 20, 1, 7),
    CAPPUCCINO("3", 200, 100, 12, 1, 6);

    private String number;
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int cost;

    KindOfCoffee(String number, int water, int milk, int coffeeBeans, int disposableCups, int cost) {
        this.number = number;
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.cost = cost;
    }

    public static KindOfCoffee findByNumber(String number) {
        for (KindOfCoffee value : values()) {
            if (number.equals(value.number)) {
                return value;
            }
        }
        return null;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getCost() {
        return cost;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public int getMilk() {
        return milk;
    }

    public String getNumber() {
        return number;
    }

    public int getWater() {
        return water;
    }
}
