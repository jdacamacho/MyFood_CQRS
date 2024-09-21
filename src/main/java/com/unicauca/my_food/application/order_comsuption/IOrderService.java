package com.unicauca.my_food.application.order_comsuption;

import java.util.List;

import com.unicauca.my_food.domain.order_consumption.Order;
import com.unicauca.my_food.domain.order_consumption.value_objects.Dish;

public interface IOrderService {
    public List<Order> getOrders();
    public Order getOrder(String idOrder);
    public Order createOrder();
    public Order updateOrder(String idOrder, Order newOrder);
    public Order addDish(String idOrder, String dishName, double dishValue);
    public Order removeDish(String idOrder, String idDish);
    public Order updateOrderState(String idOrder, int state);
    public String getOrderDate(String idOrder);
    public String getOrderHour(String idOrder);
    public List<Dish> getDishesOrder(String idOrder);
    public double calculateOrderTotalPrice(String idOrder);
}
