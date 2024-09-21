package com.unicauca.my_food.domain.inventory.value_objects;

import lombok.Getter;

@Getter
public class ProductName {
    private String name;

    public ProductName(String name) {
        if (name.isBlank())
            throw new IllegalArgumentException("The name of the product can't be blank");
        this.name = name;
    }
}
