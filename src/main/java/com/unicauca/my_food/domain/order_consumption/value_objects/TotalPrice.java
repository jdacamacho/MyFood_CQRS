package com.unicauca.my_food.domain.order_consumption.value_objects;

import java.util.List;
import java.util.UUID;

import com.unicauca.my_food.infrastucture.exceptionHandler.ownException.BusinessRuleException;

import lombok.Getter;

@Getter
public class TotalPrice {
    private String id;
    private double totalPrice;

    public TotalPrice(){
        this.id = UUID.randomUUID().toString();
        this.totalPrice = 0;
    }

    public double calculateTotalPrice(List<Dish> dishes){
        if(dishes.isEmpty())
            throw new BusinessRuleException("there are no dish to calculate a total price...");

        this.totalPrice = 0;
        dishes.forEach(dish -> this.totalPrice = this.totalPrice + dish.getPrice());
        return this.totalPrice;
    }   

}
