package com.pluralsight;

enum CheeseType {
    AMERICAN("American"),
    PROVOLONE("Provolone"),
    CHEDDAR("Cheddar"),
    SWISS("Swiss");

    private final Cheese cheeseInstance; // Holds an actual Cheese object

    CheeseType(String name) {
        this.cheeseInstance = new Cheese(name); // Create an instance of the Cheese class
    }

    public Cheese getCheese() {
        return cheeseInstance; // Return the Cheese object
    }

    public String getName() {
        return cheeseInstance.getName(); // Convenience method to get the cheese name
    }
}

public class Cheese extends PremiumToppings{

    public Cheese(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public double getPrice(SandwichSize sandwichSize) {
        return switch (sandwichSize) {
            case FOUR_INCH -> .75;
            case EIGHT_INCH -> 1.50;
            case TWELVE_INCH -> 2.25;
        };
    }
}
