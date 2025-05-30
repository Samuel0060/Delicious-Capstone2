package com.pluralsight.enums;

public enum SandwichSize {
    FOUR_INCH ("4\""),
    EIGHT_INCH ("8\""),
    TWELVE_INCH("12\"");

    private final String name;

    SandwichSize(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}