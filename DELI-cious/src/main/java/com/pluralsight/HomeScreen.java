package com.pluralsight;

import java.util.Scanner;

public class HomeScreen {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        boolean running = true;
        while (running) {
            displayMainMenuScreen();
            int selectedMenuOption = scanner.nextInt();

            switch (selectedMenuOption) {
                case 1: displayNewOrderMenu();
                        break;

                case 2:
                    running = false;
                    System.out.println("Later hungry friend!");
            }
        }
        running = false;

    }

    public static void displayMainMenuScreen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Sam's Deli Shop\n");
        System.out.println("-------------");
        System.out.println("1) New Order");
        System.out.println("2) Exit");



    }

    public static void displayNewOrderMenu() {
        Scanner scanner = new Scanner(System.in);
        Order currentOrder = null;

        System.out.println("Hungry? You're in the right place!");

        BreadTypes chosenBreadType = getBreadType(scanner);
        SandwichSize chosenSandwichSize = getSandwichSize(scanner);

    }

    public static BreadTypes getBreadType(Scanner scanner) {
        System.out.println("What type of bread would you like?");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");

        String breadTypeChoice;
        while(true) {
            breadTypeChoice = scanner.nextLine().trim();
            switch (breadTypeChoice) {
                case "1":
                    return BreadTypes.WHITE;
                case "2":
                    return BreadTypes.WHEAT;
                case "3":
                    return BreadTypes.RYE;
                case "4":
                    return BreadTypes.WRAP;
                default:
                    System.out.println("Please pick a number 1-4.");
            }
        }
    }

    public static SandwichSize getSandwichSize(Scanner scanner) {
        System.out.println("What size would you like?");
        System.out.println("1) 4\"");
        System.out.println("2) 8\"");
        System.out.println("3) 12\"");

        String sandwichSizeChoice;
        while(true) {
            sandwichSizeChoice = scanner.next().trim();
            switch (sandwichSizeChoice) {
                case "1":
                    return SandwichSize.FOUR_INCH;
                case "2":
                    return SandwichSize.EIGHT_INCH;
                case "3":
                    return SandwichSize.TWELVE_INCH;
                default:
                    System.out.println("Please pick a number between 1-3.");
            }
        }
    }
}
