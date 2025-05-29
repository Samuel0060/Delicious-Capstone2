package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
   static Scanner scanner = new Scanner(System.in);
    static Order currentOrder = null;
    public static void main(String[] args) {



        boolean running = true;
        while (running) {
            displayMainMenuScreen();
            String selectedMenuOption = scanner.nextLine();

            switch (selectedMenuOption) {
                case "1": displayNewOrderMenu();
                        break;

                case "2":
                    running = false;
                    System.out.println("Later hungry friend!");
                    System.out.println(currentOrder);
            }

        }


    }

    public static void displayMainMenuScreen() {
      //  Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Sam's Deli Shop\n");
        System.out.println("-------------");
        System.out.println("1) New Order");
        System.out.println("2) Exit");



    }

    public static void displayNewOrderMenu() {



       // Scanner scanner = new Scanner(System.in);


        System.out.println("Hungry? You're in the right place!");

        boolean isOrdering = true;

        while (isOrdering) {

            System.out.println("""
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    5) Cancel
                    """);

            String option = scanner.nextLine();


            switch (option) {
                case "1":
                    //add Sandwich
                    currentOrder = new Order(createSandwich());

                    break;

                case "2":
                    currentOrder.addDrink(addDrinkToOrder());
                    break;

                case "3":
                    break;

                case "4":
                    //checkout
                    //call the checkout method
                    isOrdering=false;

            }


        } //end of the while loop



    }

    public static SandwichMaker createSandwich(){

       // SandwichMaker sandwich = new SandwichMaker();

        //bread
        BreadTypes chosenBreadType = getBreadType();
       // sandwich.setBreadType(getBreadType(scanner));
        //size
        SandwichSize chosenSandwichSize = getSandwichSize(scanner);
        //meat
        MeatType meat = getUserMeat();
        //extra meat
        boolean extraMeat =extraMeat();
        List<RegularToppings> regTops = selectRegularToppings(scanner);
        //cheese

        //extraCheese



        return new SandwichMaker(chosenBreadType,chosenSandwichSize,meat,extraMeat,CheeseType.AMERICAN,regTops,true,SauceTypes.MAYO,true);

    }




    public static BreadTypes getBreadType() {
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

    public static MeatType getUserMeat() {


        System.out.println("What type of meat would you like?");
        System.out.println("1) Steak");
        System.out.println("2) Ham");
        System.out.println("3) Salami");
        System.out.println("4) Roast Beef");
        System.out.println("5) Chicken");
        System.out.println("6) Bacon");

        String userMeatChoice;
        while(true) {
            userMeatChoice = scanner.nextLine().trim();
        switch (userMeatChoice) {
            case "1":
                return MeatType.STEAK;
            case "2":
                return MeatType.HAM;
            case "3":
                return MeatType.SALAMI;
            case "4":
                return MeatType.ROAST_BEEF;
            case "5":
                return MeatType.CHICKEN;
            case "6":
                return MeatType.BACON;
            default:
                System.out.println("Please pick a number between 1-6");
        }
        }
    }

    static boolean extraMeat(){
        System.out.println("Extra??");
        System.out.printf("Y/N");

        String choice = scanner.nextLine();

        switch (choice.toUpperCase()){
            case "Y":
                return true;
            case "N":
                return false;
            default:
                return false;
        }

    }

    static CheeseType getUserCheese() {

    }


    public static List<RegularToppings> selectRegularToppings(Scanner scanner) {
        List<RegularToppings> selectedToppings = new ArrayList<>();
        boolean done = false;

        while (!done) {
            System.out.println("\nChoose a topping (type the number):");
            int index = 1;
            for (RegularToppingType type : RegularToppingType.values()) {
                System.out.println(index + " - " + type.name());
                index++;
            }
            System.out.println("0 - Done");

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            if (choice == 0) {
                done = true;
            } else if (choice > 0 && choice <= RegularToppingType.values().length) {
                RegularToppingType toppingType = RegularToppingType.values()[choice - 1];
                RegularToppings topping = new RegularToppings(toppingType.name());

                selectedToppings.add(topping);
                System.out.println(topping.getName() + " added!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        return selectedToppings;
    }

    static Drink addDrinkToOrder(){

        String flavor = "";
        DrinkSizes size = DrinkSizes.SMALL;

        System.out.println("Select flavor");
        System.out.println("""
                1) Coke
                2) Sprite
                """);

        String flavorInt = scanner.nextLine();

        switch (flavorInt){
            case "1":
                flavor = "Coke";
                break;
        }

        System.out.println("""
                What size?
                1) Small
                2) Medium
                3) Large
                """);

        String sizeInt = scanner.nextLine();
        switch (sizeInt){
            case "1":
            break;

            case "2":
                size = DrinkSizes.MEDIUM;
                break;
        }
        return new Drink(flavor,size);

    }
}

