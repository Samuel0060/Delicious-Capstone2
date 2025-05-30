package com.pluralsight.models;

public class Chips {
    private String name;

    public Chips(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        double price = 1.50;
        return price;
    }

    @Override
    public String toString() {
        return name;
    }
}
