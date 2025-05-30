package com.pluralsight.enums;

import com.pluralsight.models.Meat;

public enum MeatType {
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
