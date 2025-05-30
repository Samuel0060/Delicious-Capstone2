package com.pluralsight.models;

import com.pluralsight.enums.DrinkSizes;

public class Drink {
    private String name;
    private DrinkSizes size;


    public Drink(String name, DrinkSizes size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DrinkSizes getSize() {
        return size;
    }

    public double getBasePrice() {
        return switch (this.size) {
            case SMALL -> 2.00;
            case MEDIUM -> 2.50;
            case LARGE -> 3.00;
        };
    }

    @Override
    public String toString() {
        return name;
    }
}
