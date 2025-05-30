package com.pluralsight.models;

import com.pluralsight.enums.*;

import java.util.List;

public class SandwichMaker {
    private BreadType breadTypes;
    private SandwichSize size;
    private MeatType meat;
    private boolean extraMeat;
    private CheeseType cheese;
    private boolean extraCheese;
    private List<RegularToppings> regularToppings;
    private SauceType sauce;
    private boolean isToasted;


    public SandwichMaker(BreadType breadTypes, SandwichSize size, MeatType meat, boolean extraMeat, CheeseType cheese, boolean extraCheese, List<RegularToppings> regularToppings, SauceType sauce, boolean isToasted) {
        this.breadTypes = breadTypes;
        this.size = size;
        this.meat = meat;
        this.extraMeat = extraMeat;
        this.cheese = cheese;
        this.extraCheese = extraCheese;
        this.regularToppings = regularToppings;
        this.sauce = sauce;
        this.isToasted = isToasted;
    }

    public BreadType getBreadTypes() {
        return breadTypes;
    }

    public void setBreadTypes(BreadType breadTypes) {
        this.breadTypes = breadTypes;
    }

    public SandwichSize getSize() {
        return size;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public MeatType getMeat() {
        return meat;
    }

    public void setMeat(MeatType meat) {
        this.meat = meat;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public CheeseType getCheese() {
        return cheese;
    }

    public void setCheese(CheeseType cheese) {
        this.cheese = cheese;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public List<RegularToppings> getRegularToppings() {
        return regularToppings;
    }

    public void setRegularToppings(List<RegularToppings> regularToppings) {
        this.regularToppings = regularToppings;
    }

    public SauceType getSauce() {
        return sauce;
    }

    public void setSauce(SauceType sauce) {
        this.sauce = sauce;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public double getBasePrice() {
        return switch (this.size) {
            case FOUR_INCH -> 5.50;
            case EIGHT_INCH -> 7.00;
            case TWELVE_INCH -> 8.50;
        };
    }
    public double calculateCheesePrice() {
        double cheesePrice = cheese.getCheese().getPrice(size);

        if (extraCheese) {
            switch (size) {
                case FOUR_INCH -> cheesePrice += .30;
                case EIGHT_INCH -> cheesePrice += .60;
                case TWELVE_INCH -> cheesePrice += .90;
            }
        }
            return cheesePrice;
    }

    public double calculateMeatPrice() {
        double meatPrice = meat.getMeat().getPrice(size);

        if (extraMeat) {
            switch (size) {
                case FOUR_INCH -> meatPrice += 1.00;
                case EIGHT_INCH -> meatPrice += 1.50;
                case TWELVE_INCH -> meatPrice += 2.05;
            }
        }
        return meatPrice;
    }

    public double calculateSandwichPrice() {
        return getBasePrice() + calculateCheesePrice() + calculateMeatPrice();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("----- Sandwich Details -----\n");
        sb.append(String.format("Bread:         %-20s\n", breadTypes.getName()));
        sb.append(String.format("Size:          %-20s\n", size.getName()));
        sb.append(String.format("Meat:          %-20s $%.2f\n", meat.getName(), calculateMeatPrice()));
        sb.append(String.format("  Extra Meat:   %-19s\n", extraMeat ? "Yes" : "No"));
        sb.append(String.format("Cheese:        %-20s $%.2f\n", cheese.getName(), calculateCheesePrice()));
        sb.append(String.format("  Extra Cheese: %-19s\n", extraCheese ? "Yes" : "No"));

        sb.append("Toppings:\n");
        if (regularToppings.isEmpty()) {
            sb.append("               None\n");
        } else {
            for (RegularToppings topping : regularToppings) {
                sb.append(String.format("               - %s\n", topping));
            }
        }

        sb.append(String.format("Sauce:         %-20s\n", sauce));
        sb.append(String.format("Toasted:       %-20s\n", isToasted ? "Yes" : "No"));
        sb.append("\n");
        sb.append(String.format("Sandwich Subtotal:         $%.2f\n", calculateSandwichPrice()));
        sb.append("-------------------------------\n");

        return sb.toString();
    }

}

