package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public enum Coffee {
        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6);

        int mlOfWater;
        int mlOfMilk;
        int gOfCoffeeBeans;
        int price;

        Coffee(int mlOfWater, int mlOfMilk, int gOfCoffeeBeans, int price) {
            this.mlOfWater = mlOfWater;
            this.mlOfMilk = mlOfMilk;
            this.gOfCoffeeBeans = gOfCoffeeBeans;
            this.price = price;
        }
    }

    private static int storedWater = 400;
    private static int storedMilk = 540;
    private static int storedCoffeeBeans = 120;
    private static int disposableCups = 9;
    private static int money = 550;
    private static int terminate = 1;


    public static void main(String[] args) {

        while (terminate != 0)
        showMenu();

    }

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String choice = scanner.next();
        userChoice(choice);
    }

    private static boolean checkIngredients(Coffee type) {
        return  (storedWater >= type.mlOfWater &&
                storedMilk >= type.mlOfMilk &&
                storedCoffeeBeans >= type.gOfCoffeeBeans &&
                disposableCups > 0);
    }

    public static void ingredientsStored() {
        System.out.println("The coffee machine has");
        System.out.printf("%d ml of water \n", storedWater);
        System.out.printf("%d ml of milk \n", storedMilk);
        System.out.printf("%d g of coffee beans \n", storedCoffeeBeans);
        System.out.printf("%d disposable cups \n", disposableCups);
        System.out.printf("$%d of money \n", money);
    }

    public static void storeIngredients() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add:");
        storedWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        storedMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        storedCoffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee beans you want to add:");
        disposableCups += scanner.nextInt();


    }

    public static void userChoice(String choice){
        switch (choice) {

            case "buy":
                buy();
                showMenu();
                break;

            case "fill":
                storeIngredients();
                showMenu();
                break;

            case "take":
                System.out.printf("I gave you $%d \n", money);
                money = 0;
                showMenu();
                break;

            case "remaining":
                ingredientsStored();
                showMenu();
                break;

            case "exit":
                terminate = 0;
                System.exit(0);

        }
    }

    public static void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");

        String choice = scanner.next();

        switch (choice) {

            case "1":
                if (checkIngredients(Coffee.ESPRESSO)) {
                    storedWater -= Coffee.ESPRESSO.mlOfWater;
                    storedMilk -= Coffee.ESPRESSO.mlOfMilk;
                    storedCoffeeBeans -= Coffee.ESPRESSO.gOfCoffeeBeans;
                    money += Coffee.ESPRESSO.price;
                    disposableCups--;
                } else {
                    if (storedWater < Coffee.ESPRESSO.mlOfWater) {
                        System.out.println("Sorry, not enough water!");
                    }
                    if (storedMilk < Coffee.ESPRESSO.mlOfMilk) {
                        System.out.println("Sorry, not enough milk!");
                    }
                    if (storedCoffeeBeans < Coffee.ESPRESSO.gOfCoffeeBeans) {
                        System.out.println("Sorry, not enough coffee beans!");
                    }
                    if (disposableCups <= 0) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                }
                break;

            case "2":
                if (checkIngredients(Coffee.LATTE)) {
                    storedWater -= Coffee.LATTE.mlOfWater;
                    storedMilk -= Coffee.LATTE.mlOfMilk;
                    storedCoffeeBeans -= Coffee.LATTE.gOfCoffeeBeans;
                    money += Coffee.LATTE.price;
                    disposableCups--;
                } else {
                        if (storedWater < Coffee.LATTE.mlOfWater) {
                            System.out.println("Sorry, not enough water!");
                        }
                        if (storedMilk < Coffee.LATTE.mlOfMilk) {
                            System.out.println("Sorry, not enough milk!");
                        }
                        if (storedCoffeeBeans < Coffee.LATTE.gOfCoffeeBeans) {
                            System.out.println("Sorry, not enough coffee beans!");
                        }
                        if (disposableCups <= 0) {
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                    }
                break;

            case "3":
                if (checkIngredients(Coffee.CAPPUCCINO)) {
                    storedWater -= Coffee.CAPPUCCINO.mlOfWater;
                    storedMilk -= Coffee.CAPPUCCINO.mlOfMilk;
                    storedCoffeeBeans -= Coffee.CAPPUCCINO.gOfCoffeeBeans;
                    money += Coffee.CAPPUCCINO.price;
                    disposableCups--;
                } else {
                    if (storedWater < Coffee.CAPPUCCINO.mlOfWater) {
                        System.out.println("Sorry, not enough water!");
                    }
                    if (storedMilk < Coffee.CAPPUCCINO.mlOfMilk) {
                        System.out.println("Sorry, not enough milk!");
                    }
                    if (storedCoffeeBeans < Coffee.CAPPUCCINO.gOfCoffeeBeans) {
                        System.out.println("Sorry, not enough coffee beans!");
                    }
                    if (disposableCups <= 0) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                }
                break;

            case "back":
                showMenu();
                break;

            default:
                System.out.println("Please select available options.");


        }

    }

}
