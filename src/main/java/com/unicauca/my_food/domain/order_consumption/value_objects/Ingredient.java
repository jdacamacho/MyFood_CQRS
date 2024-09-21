package com.unicauca.my_food.domain.order_consumption.value_objects;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Ingredient {
    private String id;
    private String name;

    public Ingredient(){
        this.id = UUID.randomUUID().toString();
    }
}
