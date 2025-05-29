package com.pluralsight;

 enum MeatType {
    STEAK("Steak"),
    HAM("Ham"),
    SALAMI("Salami"),
    ROAST_BEEF("Roast Beef"),
    CHICKEN("Chicken"),
    BACON("Bacon");

    private final Meat meatInstance;

    MeatType(String name) {
        this.meatInstance = new Meat(name);
    }

    public Meat getMeat() {
        return meatInstance;
    }

    public String getName() {
        return meatInstance.getName();
    }
}

public class Meat extends PremiumToppings {

    public Meat(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
