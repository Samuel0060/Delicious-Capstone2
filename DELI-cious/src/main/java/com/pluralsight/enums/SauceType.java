package com.pluralsight.enums;

import com.pluralsight.models.Sauce;

public enum SauceType {
    MAYO("Mayo"),
    MUSTARD("Mustard"),
    KETCHUP("Ketchup"),
    RANCH("Ranch"),
    THOUSAND_ISLANDS("Thousand Islands"),
    VINAIGRETTE("Vinaigrette");

    private final Sauce sauceInstance;

    SauceType(String name) {
        this.sauceInstance = new Sauce(name);
    }

    public Sauce getSauce() {
        return sauceInstance;
    }

    public String getName() {
        return sauceInstance.getName();
    }
}
