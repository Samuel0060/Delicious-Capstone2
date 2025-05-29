package com.pluralsight;

enum SauceTypes {
    MAYO("Mayo"),
    MUSTARD("Mustard"),
    KETCHUP("Ketchup"),
    RANCH("Ranch"),
    THOUSAND_ISLANDS("Thousand Islands"),
    VINAIGRETTE("Vinaigrette");

    private final Sauce sauceInstance;

    SauceTypes(String name) {
        this.sauceInstance = new Sauce(name);
    }

    public Sauce getSauce() {
        return sauceInstance;
    }

    public String getName() {
        return sauceInstance.getName();
    }
}

public class Sauce extends RegularToppings{
    public Sauce(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
