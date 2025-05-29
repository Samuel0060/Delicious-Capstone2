package com.pluralsight;

enum RegularToppingType {
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
public class RegularToppings extends AbstractToppings{

    public RegularToppings(String name) {
        super(name);
    }

    @Override
    public double getPrice(SandwichSize size) {
        return 0;
    }
}


