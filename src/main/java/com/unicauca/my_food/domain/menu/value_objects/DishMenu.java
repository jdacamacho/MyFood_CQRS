package com.unicauca.my_food.domain.menu.value_objects;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.UUID;
import java.util.ArrayList;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DishMenu {
    private String id; 
    private String name; 
    private List<IngredientDish> ingredients;
    private double price;

    public DishMenu(String name, double price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>();
    }

    public boolean addIngredient(IngredientDish ingredient) {
        if (ingredient == null) return false;
        return this.ingredients.add(ingredient);
    }

    public boolean removeIngredient(String id) {
        if (id == null || this.ingredients == null) {
            return false;
        }

        for (int i = 0; i < this.ingredients.size(); i++) {
            if (this.ingredients.get(i).getId().equals(id)) { 
                this.ingredients.remove(i);
                return true; 
            }
        }
        return false; 

    }

}
