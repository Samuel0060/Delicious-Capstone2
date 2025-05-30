package com.pluralsight.models;

import com.pluralsight.enums.SandwichSize;

public class RegularToppings extends AbstractToppings {

    public RegularToppings(String name) {
        super(name);
    }

    @Override
    public double getPrice(SandwichSize size) {
        return 0;
    }

    @Override
    public String toString() {
        return name;
    }

}


