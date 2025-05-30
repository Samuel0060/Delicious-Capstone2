package com.pluralsight.models;

public class Meat extends PremiumToppings {

    public Meat(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
