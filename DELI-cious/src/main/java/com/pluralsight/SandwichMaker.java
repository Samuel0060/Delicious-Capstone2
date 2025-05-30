package com.pluralsight;

import java.util.List;

public class SandwichMaker {
    private BreadTypes breadTypes;
    private SandwichSize size;
    private MeatType meat;
    private boolean extraMeat;
    private CheeseType cheese;
    private boolean extraCheese;
    private List<RegularToppings> regularToppings;
    private SauceTypes sauce;
    private boolean isToasted;


    public SandwichMaker(BreadTypes breadTypes, SandwichSize size, MeatType meat, boolean extraMeat, CheeseType cheese, boolean extraCheese, List<RegularToppings> regularToppings, SauceTypes sauce, boolean isToasted) {
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

    public BreadTypes getBreadTypes() {
        return breadTypes;
    }

    public void setBreadTypes(BreadTypes breadTypes) {
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

    public SauceTypes getSauce() {
        return sauce;
    }

    public void setSauce(SauceTypes sauce) {
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
        sb.append("----- Sam's Deli Receipt -----\n");
        sb.append("Item: 1 Sandwich \t\t ").append(String.format("%.2f",calculateSandwichPrice())).append("\n");
        sb.append("-----------------------------\n");
        sb.append("Bread:        ").append(breadTypes).append("\n");
        sb.append("Size:         ").append(size.getName()).append("\n");
        sb.append("Meat:         ").append(meat).append("\n");
        sb.append("  Extra Meat: ").append(extraMeat ? "Yes" : "No").append("\n");
        sb.append("Cheese:       ").append(cheese).append("\n");
        sb.append("  Extra Cheese: ").append(extraCheese ? "Yes" : "No").append("\n");
        sb.append("Toppings:     ").append(regularToppings).append("\n");
        sb.append("Sauce:        ").append(sauce).append("\n");
        sb.append("Toasted:      ").append(isToasted ? "Yes" : "No").append("\n");
        sb.append("\n");


        return sb.toString();
    }
}

