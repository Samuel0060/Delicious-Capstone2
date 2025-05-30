package com.pluralsight.interfaces;

import com.pluralsight.enums.SandwichSize;

public interface Topping {
    String getName();

    double getPrice(SandwichSize size);

}
