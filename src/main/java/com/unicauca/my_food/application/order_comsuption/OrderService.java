package com.unicauca.my_food.application.order_comsuption;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unicauca.my_food.domain.order_consumption.Order;
import com.unicauca.my_food.domain.order_consumption.service.OrderDomainService;
import com.unicauca.my_food.domain.order_consumption.value_objects.Dish;
import com.unicauca.my_food.infrastucture.exceptionHandler.ownException.ObjectNotFoundException;
import com.unicauca.my_food.infrastucture.repositories.OrderRepository;

@Service
public class OrderService implements IOrderService{
    private final OrderDomainService serviceDomain;
    private final OrderRepository repository;

    public OrderService(OrderDomainService serviceDomain, OrderRepository repository) {
        this.serviceDomain = serviceDomain;
        this.repository = repository;
    }

    @Override
    public List<Order> getOrders() {
        return this.repository.findAll();
    }

    @Override
    public Order getOrder(String idOrder) {
        return this.repository.findById(idOrder);
    }

    @Override
    public Order createOrder() {
        Order order = new Order();
        this.repository.save(order);
        return order;
    }

    @Override
    public Order updateOrder(String idOrder, Order newOrder) {
        if(this.repository.findById(idOrder) == null)
            throw new ObjectNotFoundException("Order was not found");
        
        this.repository.update(idOrder, newOrder);
        return newOrder;
    }

    @Override
    public Order updateOrderState(String idOrder, int state) {
        Order order = this.repository.findById(idOrder);
        if(order == null)
            throw new ObjectNotFoundException("Order was not found");
        
        this.serviceDomain.changeOrderState(order, state);
        return order;
    }

    @Override
    public String getOrderDate(String idOrder) {
        Order order = this.repository.findById(idOrder);
        if(order == null)
            throw new ObjectNotFoundException("Order was not found");
        
        return this.serviceDomain.getOrderDate(order);
    }

    @Override
    public String getOrderHour(String idOrder) {
        Order order = this.repository.findById(idOrder);
        if(order == null)
            throw new ObjectNotFoundException("Order was not found");
        
        return this.serviceDomain.getOrderHour(order);
    }

    @Override
    public List<Dish> getDishesOrder(String idOrder) {
        Order order = this.repository.findById(idOrder);
        if(order == null)
            throw new ObjectNotFoundException("Order was not found");
        
        return order.getDishes();
    }

    @Override
    public double calculateOrderTotalPrice(String idOrder) {
        Order order = this.repository.findById(idOrder);
        if(order == null)
            throw new ObjectNotFoundException("Order was not found");
        
        return this.serviceDomain.calculateTotalPrice(order);
    }

    @Override
    public Order addDish(String idOrder, String dishName, double dishValue) {
        Order order = this.repository.findById(idOrder);
        if(order == null)
            throw new ObjectNotFoundException("Order was not found");

        Dish dish = new Dish(dishName, dishValue);
        this.serviceDomain.addDish(order, dish);
        return order;
    }

    @Override
    public Order removeDish(String idOrder, String idDish) {
        Order order = this.repository.findById(idOrder);
        if(order == null)
            throw new ObjectNotFoundException("Order was not found");

        this.serviceDomain.removeDish(order, idDish);
        return order;
    }

}
