package com.unicauca.my_food.application.order_comsuption_my_sql;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unicauca.my_food.domain.order_consumption.Order;
import com.unicauca.my_food.domain.order_consumption.service.OrderDomainService;
import com.unicauca.my_food.domain.order_consumption.value_objects.Dish;
import com.unicauca.my_food.infrastucture.MySQL.entities.OrderEntity;
import com.unicauca.my_food.infrastucture.MySQL.repository.OrderMySqlRepository;
import com.unicauca.my_food.infrastucture.exceptionHandler.ownException.BusinessRuleException;
import com.unicauca.my_food.infrastucture.exceptionHandler.ownException.ObjectNotFoundException;

@Service
public class OrderService implements IOrderService{
    private final OrderDomainService serviceDomain;
    private final OrderMySqlRepository db;
    private final ModelMapper mapper;

    public OrderService(OrderDomainService serviceDomain, OrderMySqlRepository db, ModelMapper mapper) {
        this.serviceDomain = serviceDomain;
        this.db = db;
        this.mapper = mapper;
    }

    @Override
    public Order createOrder() {
        Order orderDomain = new Order();

        OrderEntity orderEntity = this.mapper.map(orderDomain, OrderEntity.class);
        orderEntity.getDate().setObjOrder(orderEntity);
        orderEntity.getState().setObjOrder(orderEntity);
        orderEntity.getTotalPrice().setObjOrder(orderEntity);

        OrderEntity orderSaved = this.db.save(orderEntity);
        Order response = this.mapper.map(orderSaved, Order.class);

        return response;
    }

    @Override
    public Order addDish(String idOrder, String dishName, double dishValue) {
        if(!this.db.existsById(idOrder))
            throw new ObjectNotFoundException("Order not found...");
        
        OrderEntity orderEntity = this.db.findById(idOrder).get();
        Order orderDomain = this.mapper.map(orderEntity, Order.class);

        Dish dish = new Dish(dishName, dishValue);
        
        this.serviceDomain.addDish(orderDomain, dish);

        OrderEntity orderToSave = this.mapper.map(orderDomain, OrderEntity.class);
        OrderEntity orderUpdated = this.db.save(orderToSave);

        Order response = this.mapper.map(orderUpdated, Order.class);
        return response;
    }

    @Override
    public Order removeDish(String idOrder, String idDish) {
        if(!this.db.existsById(idOrder))
            throw new ObjectNotFoundException("Order not found...");
        
        OrderEntity orderEntity = this.db.findById(idOrder).get();

        Order orderDomain = this.mapper.map(orderEntity, Order.class);
        boolean flag = this.serviceDomain.removeDish(orderDomain, idDish);

        if(flag){
            OrderEntity orderToSave = this.mapper.map(orderDomain, OrderEntity.class);
            OrderEntity orderUpdated = this.db.save(orderToSave);
            Order response = this.mapper.map(orderUpdated, Order.class);
            return response;
        }

        throw new ObjectNotFoundException("Dish was not found...");
    }

    @Override
    public Order updateOrderState(String idOrder, int state) {
        if(!this.db.existsById(idOrder))
            throw new ObjectNotFoundException("Order not found...");
    
        OrderEntity orderEntity = this.db.findById(idOrder).get();
        Order orderDomain = this.mapper.map(orderEntity, Order.class);

        boolean flag = this.serviceDomain.changeOrderState(orderDomain, state);

        if(flag){
            OrderEntity orderToSave = this.mapper.map(orderDomain, OrderEntity.class);
            orderToSave.getState().setObjOrder(orderToSave);
            OrderEntity orderUpdated = this.db.save(orderToSave);
            Order response = this.mapper.map(orderUpdated, Order.class);
            return response;
        }

        throw new BusinessRuleException("State is not valid...");
    }

    @Override
    public double calculateOrderTotalPrice(String idOrder) {
        if(!this.db.existsById(idOrder))
            throw new ObjectNotFoundException("Order not found...");
    
        OrderEntity orderEntity = this.db.findById(idOrder).get();
        Order orderDomain = this.mapper.map(orderEntity, Order.class);

        double totalPrice = this.serviceDomain.calculateTotalPrice(orderDomain);

        OrderEntity orderToSave = this.mapper.map(orderDomain, OrderEntity.class);
        orderToSave.getTotalPrice().setObjOrder(orderToSave);
        this.db.save(orderToSave);

        return totalPrice;
    }

}
