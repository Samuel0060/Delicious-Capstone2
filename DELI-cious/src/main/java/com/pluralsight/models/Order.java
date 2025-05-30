package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<SandwichMaker> sandwiches = new ArrayList<>();
    private Chips chips;
    private Drink drink;

    public Order() {}

    public List<SandwichMaker> getSandwiches() {
        return sandwiches;
    }

    public void addSandwich(SandwichMaker sandwich) {
        sandwiches.add(sandwich);
    }

    public Drink getDrink() {
        return drink;
    }

    public void addDrink(Drink drink) {
        this.drink = drink;
    }

    public void removeDrink() {
        this.drink = null;
    }

    public boolean hasDrink() {
        return this.drink != null;
    }

    public Chips getChips() {
        return chips;
    }

    public void addChips(Chips chips) {
        this.chips = chips;
    }

    public void removeChips() {
        this.chips = null;
    }

    public boolean hasChips() {
        return this.chips != null;
    }

    public double calculateOrderTotalPrice() {
        double total = 0;
        for (SandwichMaker sandwich : sandwiches) {
            total += sandwich.calculateSandwichPrice();
        }
        if (hasChips()) {
            total += chips.getPrice();
        }
        if (hasDrink()) {
            total += drink.getBasePrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("======= Your Receipt =======\n");

        if (sandwiches.isEmpty()) {
            sb.append("No sandwiches ordered.\n\n");
        } else {
            int count = 1;
            for (SandwichMaker sandwich : sandwiches) {
                sb.append("Sandwich ").append(count++).append(":\n");
                sb.append(sandwich).append("\n");
            }
        }

        if (hasChips()) {
            sb.append("Chips: ").append(chips.getName()).append("\t\t$").append(String.format("%.2f", chips.getPrice())).append("\n");
        } else {
            sb.append("Chips: None\t\t$0.00\n");
        }

        if (hasDrink()) {
            sb.append("Drink: ").append(drink.toString()).append("\t\t$").append(String.format("%.2f", drink.getBasePrice())).append("\n");
        } else {
            sb.append("Drink: None\t\t$0.00\n");
        }

        sb.append("-------------------------------\n");
        sb.append("Total Order Price: $").append(String.format("%.2f", calculateOrderTotalPrice())).append("\n");

        return sb.toString();
    }
}
