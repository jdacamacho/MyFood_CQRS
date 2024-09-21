package com.unicauca.my_food.domain.menu;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import com.unicauca.my_food.domain.menu.value_objects.DateMenu;
import com.unicauca.my_food.domain.menu.value_objects.DishMenu;
import lombok.Getter;

@Getter

public class Menu {
    private String id;
    private List<DishMenu> dishes;
    private DateMenu date;

    public Menu(){
        this.id =  UUID.randomUUID().toString();
        this.date = new DateMenu();
        this.dishes = new ArrayList<>(); 
    }

    public boolean addDish(DishMenu dish){
        if (dish == null) return false;
        return this.dishes.add(dish);
    }

    public boolean removeDish(String id){
        //Devuelve true si un elemento es eliminado 
        return this.dishes.removeIf(dish -> dish.getId().equals(id));
    }

    public DishMenu getDish(String id){
        //Devuelve un platillo en especifico 
        for (DishMenu dish : this.dishes) {
            if (dish.getId().equals(id)) {
                return dish;
            }
        }
        return null;
    }

    public List<DishMenu> getDishes() {
        //Devuelve una lista de los platillos 
        return this.dishes;
    }

}








