package com.pluralsight.models;

public class Sauce extends RegularToppings {
    public Sauce(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
