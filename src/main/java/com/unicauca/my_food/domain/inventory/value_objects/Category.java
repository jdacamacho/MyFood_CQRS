package com.unicauca.my_food.domain.inventory.value_objects;

import lombok.Getter;

@Getter
public enum Category {
    FRUITS("Fruits"),
    VEGETABLES("Vegetables"),
    DAIRY("Dairy"),
    MEAT("Meat"),
    SEAFOOD("Seafood"),
    GRAINS("Grains"),
    BEVERAGES("Beverages"),
    SWEETS("Sweets"),
    SNACKS("Snacks"),
    CONDIMENTS("Condiments"),
    LEGUMES("Legumes"),
    NUTS_AND_SEEDS("Nuts and Seeds");

    private final String desciptiveName;

    Category(String desciptiveName) {
        this.desciptiveName = desciptiveName;
    }
}
