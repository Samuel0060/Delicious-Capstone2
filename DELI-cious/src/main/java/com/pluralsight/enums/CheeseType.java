package com.pluralsight.enums;
import com.pluralsight.models.Cheese;;

public enum CheeseType {
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