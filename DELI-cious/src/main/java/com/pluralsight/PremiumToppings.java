package com.pluralsight;

public class PremiumToppings extends AbstractToppings {

    public PremiumToppings(String name) {
        super(name);
    }

    @Override
    public double getPrice(SandwichSize sandwichSize) {
        return switch (sandwichSize) {
            case FOUR_INCH -> 1.00;
            case EIGHT_INCH -> 2.00;
            case TWELVE_INCH -> 3.00;
        };

    }





}
