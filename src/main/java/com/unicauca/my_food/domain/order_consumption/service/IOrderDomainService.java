package com.unicauca.my_food.domain.order_consumption.service;

import com.unicauca.my_food.domain.order_consumption.Order;
import com.unicauca.my_food.domain.order_consumption.value_objects.Dish;
import com.unicauca.my_food.domain.order_consumption.value_objects.Ingredient;

public interface IOrderDomainService {
    public boolean changeOrderState(Order order, int state); 
    public boolean addDish(Order order, Dish dish);
    public boolean removeDish(Order order, String idDish);
    public boolean addIngredient(Dish dish, Ingredient ingredient);
    public boolean removeIngredient(Dish dish, String idIngredient);
    public String getOrderDate(Order order);
    public String getOrderHour(Order order);
    public double calculateTotalPrice(Order order);
}
