package com.unicauca.my_food.domain.inventory.value_objects;

import lombok.Getter;

@Getter
public enum Units {
    MILLILITERS("ml"),
    LITERS("l"),
    CUPS("cup"),
    TEASPOONS("tsp"),
    TABLESPOONS("tbsp"),
    FLUID_OUNCES("fl oz"),
    GRAMS("g"),
    KILOGRAMS("kg"),
    OUNCES("oz"),
    POUNDS("lb"),
    PIECES("pieces"),
    SLICES("slices"),
    SERVINGS("servings");

    private final String abbreviation;

    Units(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
