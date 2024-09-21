package com.unicauca.my_food.domain.order_consumption;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.unicauca.my_food.domain.order_consumption.value_objects.Dish;
import com.unicauca.my_food.domain.order_consumption.value_objects.OrderDate;
import com.unicauca.my_food.domain.order_consumption.value_objects.OrderState;
import com.unicauca.my_food.domain.order_consumption.value_objects.TotalPrice;
import com.unicauca.my_food.infrastucture.exceptionHandler.ownException.ObjectNotFoundException;
import com.unicauca.my_food.infrastucture.exceptionHandler.ownException.ObjectNullException;

import lombok.Getter;

@Getter
public class Order {
    private String id;
    private OrderDate date;
    private OrderState state;
    private List<Dish> dishes;
    private TotalPrice totalPrice;    

    public Order(){
        this.id = UUID.randomUUID().toString();
        this.date = new OrderDate();
        this.state = new OrderState(0);
        this.dishes = new ArrayList<>();
        this.totalPrice = new TotalPrice();
    }

    public boolean changeState(int state){
        this.state = new OrderState(state);
        return true;
    }

    public boolean addDish(Dish dish){
        if(this.dishes == null)
            throw new ObjectNullException("Dishes is null...");

        if(dish == null)
            throw new ObjectNullException("Dish is null...");

        this.dishes.add(dish);
        return true;
    }

    public boolean removeDish(String id){
        if(this.dishes == null)
            throw new ObjectNullException("Dishes is null...");

        if(id.isBlank())
            throw new ObjectNullException("Dish's id is null...");

        for(int i = 0 ; i < this.dishes.size() ; i++){
            if(this.dishes.get(i).getId().equals(id)){
                this.dishes.remove(i);
                return true;
            }
        }

        throw new ObjectNotFoundException("Dish was not found...");
    }

}
