package com.pluralsight.enums;

import com.pluralsight.models.RegularToppings;

public enum RegularToppingType {
    LETTUCE("Lettuce"),
    PEPPERS("Peppers"),
    ONIONS("Onions"),
    TOMATOES("Tomatoes"),
    JALAPENOS("Jalapenos"),
    CUCUMBERS("Cucumbers"),
    PICKLES("Pickles"),
    GUACOMALE("Guacamole"),
    MUSHROOMS("Mushrooms");

    private final RegularToppings regularToppingsInstance;

    RegularToppingType(String name) {
        this.regularToppingsInstance = new RegularToppings(name);
    }

    public RegularToppings getRegularToppingsInstance() {
        return regularToppingsInstance;
    }

    public String getName() {
        return regularToppingsInstance.getName();
    }
}