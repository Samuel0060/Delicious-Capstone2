package com.pluralsight;

public class Chips {
    private final String name = "Chips";
    private final double price = 1.50;

    public Chips() {
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + String.format("%.2f", price) + ")";
    }
}
