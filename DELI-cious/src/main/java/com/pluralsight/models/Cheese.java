package com.pluralsight.models;

import com.pluralsight.enums.SandwichSize;

public class Cheese extends PremiumToppings {

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
