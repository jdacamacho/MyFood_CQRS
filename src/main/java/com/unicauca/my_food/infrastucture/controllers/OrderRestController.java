package com.unicauca.my_food.infrastucture.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.my_food.application.order_comsuption_my_sql.IOrderService;
import com.unicauca.my_food.domain.order_consumption.Order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderRestController {
   private final IOrderService service;

    @PostMapping("")
    public ResponseEntity<Order> createOrder(){
        Order order = this.service.createOrder();
        return new ResponseEntity<Order>(order, HttpStatus.CREATED);
    }

    @PatchMapping("dishes/{idOrder}")
    public ResponseEntity<Order> addDishToOrder(@PathVariable String idOrder, 
                                                @RequestParam String dishName, 
                                                @RequestParam double dishValue){
        Order order = this.service.addDish(idOrder, dishName, dishValue);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @DeleteMapping("dishes/{idOrder}/{idDish}")
    public ResponseEntity<Order> removeDishToOrder(@PathVariable String idOrder, 
                                                @PathVariable String idDish){
        Order order = this.service.removeDish(idOrder, idDish);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
    
    @PutMapping("/{idOrder}/{state}")
    public ResponseEntity<Order> updateOrderState(@PathVariable String idOrder, 
                                                @PathVariable int state){
        Order order = this.service.updateOrderState(idOrder, state);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @PostMapping("/{idOrder}")
    public ResponseEntity<Double> calculateOrderTotalPrice(@PathVariable String idOrder){
        double totalPrice = this.service.calculateOrderTotalPrice(idOrder);
        return new ResponseEntity<>(totalPrice,HttpStatus.OK);
    }

}
