package com.pluralsight;

public class Chips {
    private final String name = "Chips";
//    private final double price = 1.50;

    public Chips(String name) {
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
