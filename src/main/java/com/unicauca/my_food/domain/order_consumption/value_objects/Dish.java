package com.unicauca.my_food.domain.order_consumption.value_objects;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.unicauca.my_food.infrastucture.exceptionHandler.ownException.ObjectNotFoundException;
import com.unicauca.my_food.infrastucture.exceptionHandler.ownException.ObjectNullException;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Dish {
    private String id;
    private String name;
    private List<Ingredient> ingredients;
    private double price;

    public Dish(String name, double price ){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>();
    }

    public boolean addIngredient(Ingredient ingredient){
        if(this.ingredients == null)
            throw new ObjectNullException("Ingredients is null...");
        
        if(ingredient == null)
            throw new ObjectNullException("Ingredient is null...");

        this.ingredients.add(ingredient);
        return true;
    }

    public boolean removeIngredient(String id){
        if(this.ingredients == null)
            throw new ObjectNullException("Ingredients is null...");
        
        if(id.isBlank())
            throw new ObjectNullException("Ingredient's id is null...");

        for(int i = 0 ; i < this.ingredients.size() ; i++){
            if(this.ingredients.get(i).getId().equals(id)){
                this.ingredients.remove(i);
                return true;
            }
        }

        throw new ObjectNotFoundException("id was not found...");
    }
}
