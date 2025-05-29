package com.pluralsight;

public abstract class AbstractToppings implements Topping {
    protected String name; // Protected so subclasses can access it

    public AbstractToppings(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


}