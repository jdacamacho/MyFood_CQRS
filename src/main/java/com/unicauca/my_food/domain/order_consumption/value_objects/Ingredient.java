package com.unicauca.my_food.domain.order_consumption.value_objects;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Ingredient {
    private String id_date;
    private String name;

    public Ingredient(){
        this.id_date = UUID.randomUUID().toString();
    }
}
