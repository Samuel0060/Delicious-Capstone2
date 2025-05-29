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
                    currentOrder.addChips(addChipsToOrder());
                    break;

                case "4":
                    //checkout
                    displayCheckoutScreen();
                    //call the checkout method
                    isOrdering=false;

            }


        } //end of the while loop



    }

    public static SandwichMaker createSandwich(){

//        SandwichMaker sandwich = new SandwichMaker();

        //bread
        BreadTypes chosenBreadType = getBreadType();
        //size
        SandwichSize chosenSandwichSize = getSandwichSize();
        //meat
        MeatType meat = getUserMeat();
        //extra meat
        boolean extraMeat =extraMeat();
        //cheese
        CheeseType cheese = getUserCheese();
        //extraCheese
        boolean extraCheese = extraCheese();
        //regular toppings
        List<RegularToppings> regTops = selectRegularToppings();
        //sauce
        SauceTypes sauce = getUserSauces();
        //toasted
        boolean isToasted = isItToasted();




        return new SandwichMaker(chosenBreadType,
                chosenSandwichSize,
                meat,
                extraMeat,
                cheese,
                extraCheese,
                regTops,
                sauce,
                isToasted);

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

    public static SandwichSize getSandwichSize() {
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
        System.out.println("What type of Cheese would you like?");
        System.out.println("1) American");
        System.out.println("2) Provolone");
        System.out.println("3) Cheddar");
        System.out.println("4) Swiss");

        String userCheeseChoice;
        while(true){
            userCheeseChoice = scanner.nextLine();

            switch(userCheeseChoice) {
                case "1":
                    return CheeseType.AMERICAN;
                case "2":
                    return CheeseType.PROVOLONE;
                case "3":
                    return CheeseType.CHEDDAR;
                case "4":
                    return CheeseType.SWISS;
                default:
                    System.out.println("Please pick a number between 1 and 4");
            }
        }
    }

    static boolean extraCheese() {
        System.out.println("Extra??");
        System.out.println("Y/N");

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

    public static List<RegularToppings> selectRegularToppings() {
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

    static SauceTypes getUserSauces() {
        System.out.println("What type of Sauce would you like?");
        System.out.println("1) Mayo");
        System.out.println("2) Mustard");
        System.out.println("3) Ketchup");
        System.out.println("4) Ranch");
        System.out.println("5) Thousand Islands");
        System.out.println("6) Vinaigrette");

        String userSauce;
        while(true) {
            userSauce = scanner.nextLine();
            switch (userSauce) {
                case "1":
                    return SauceTypes.MAYO;
                case "2":
                    return SauceTypes.MUSTARD;
                case "3":
                    return SauceTypes.KETCHUP;
                case "4":
                    return SauceTypes.RANCH;
                case "5":
                    return SauceTypes.THOUSAND_ISLANDS;
                case "6":
                    return SauceTypes.VINAIGRETTE;
                default:
                    System.out.println("Please pick a number between 1-6");
            }
        }
    }

    static boolean isItToasted() {
        System.out.println("Would you like it toasted?");
        System.out.println("Y/N");

        String userToastedChoice;
        while (true) {
            userToastedChoice = scanner.nextLine().toUpperCase();
            switch (userToastedChoice) {
                case "Y":
                    return true;
                case "N":
                    return false;
                default:
                    return false;
            }
        }

    }

    static Drink addDrinkToOrder(){

        String flavor = "";
        DrinkSizes size = DrinkSizes.SMALL;

        System.out.println("Select flavor");
        System.out.println("""
                1) Coke
                2) Sprite
                3) Pepsi
                4) Starry
                5) Fruit Punch
                6) Water
                """);

        String flavorInt = scanner.nextLine();

        switch (flavorInt){
            case "1":
                flavor = "Coke";
                break;
            case "2":
                flavor = "Sprite";
                break;
            case "3":
                flavor = "Pepsi";
                break;
            case "4":
                flavor = "Starry";
                break;
            case "5":
                flavor = "Fruit Punch";
                break;
            case "6":
                flavor = "Water";
            default:
                System.out.println("Please pick a number 1-6");
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
            case "3":
                size = DrinkSizes.LARGE;
        }
        return new Drink(flavor,size);

    }

    static Chips addChipsToOrder() {

        String name;
        System.out.println("Select Chips");
        System.out.println("""
                1) Doritos
                2) Lays
                3) Cheetos
                4) Fritos
                """);

        String userChipsChoice;
        while (true) {
            userChipsChoice = scanner.nextLine();
            switch (userChipsChoice) {
                case "1":
                    name = "Doritos";
                    break;
                case "2":
                    name = "Lays";
                case "3":
                    name = "Cheetos";
                case "4":
                    name = "Fritos";
                default:
                    System.out.println("Please pick a number 1-4");
            }
        }

    }

    static Order displayCheckoutScreen() {
        return currentOrder;
    }
}

