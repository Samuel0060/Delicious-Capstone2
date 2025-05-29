package com.pluralsight;

public enum BreadTypes {
    WHITE("White"),
    WHEAT("Wheat"),
    RYE("Rye"),
    WRAP("Wrap");

    private final String name;

    BreadTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
