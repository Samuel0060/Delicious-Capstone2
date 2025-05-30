package com.pluralsight.enums;

public enum BreadType {

        WHITE("White"),
        WHEAT("Wheat"),
        RYE("Rye"),
        WRAP("Wrap");

        private final String name;

        BreadType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
