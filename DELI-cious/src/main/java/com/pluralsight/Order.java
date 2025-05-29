package com.pluralsight;

public class Order {
    private SandwichMaker sandwich;
    private Chips chips;
    private Drink drink;// Optional: can be null if no chips are ordered

    public Order(SandwichMaker sandwich) {
        if (sandwich == null) {
            throw new IllegalArgumentException("An order must include a sandwich.");
        }
        this.sandwich = sandwich;
    }

    // --- Getters and Setters for Order Components ---
    public SandwichMaker getSandwich() {
        return sandwich;
    }

    public Drink getDrink() {
        return drink;
    }

    public void addDrink(Drink drink) {
        this.drink = drink; // Create the single type of chips
    }

    public void removeDrink() {
        this.drink = null; // Remove chips from the order
    }

    public boolean hasDrink() {
        return this.drink != null;
    }

    public Chips getChips() {
        return chips;
    }

    public void addChips(Chips chips) {
        this.chips = chips; // Create the single type of chips
    }

    public void removeChips() {
        this.chips = null; // Remove chips from the order
    }

    public boolean hasChips() {
        return this.chips != null;
    }

    // Total Price for Entire Order
    public double calculateOrderTotalPrice() {
        double total = sandwich.calculateSandwichPrice(); // Start with sandwich price
        if (hasChips()) {
            total += chips.getPrice(); // Add chips price if present
        }
        if (hasDrink()) {
            total += drink.getBasePrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("--- Customer Order ---\n");
        orderDetails.append(sandwich.toString()).append("\n"); // Include sandwich details

        if (hasChips()) {
            orderDetails.append("  Chips: ").append(chips.toString()).append("\n");
            orderDetails.append("  Chips Cost: $").append(String.format("%.2f", chips.getPrice())).append("\n");
        } else {
            orderDetails.append("  Chips: None\n");
            orderDetails.append("  Chips Cost: $0.00\n");
        }

        orderDetails.append("----------------------\n");
        orderDetails.append("Total Order Price: $").append(String.format("%.2f", calculateOrderTotalPrice()));
        return orderDetails.toString();
    }
}
