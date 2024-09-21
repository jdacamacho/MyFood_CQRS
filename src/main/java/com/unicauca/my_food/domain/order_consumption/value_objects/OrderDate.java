package com.unicauca.my_food.domain.order_consumption.value_objects;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import lombok.Getter;

@Getter
public class OrderDate {
    private String id;
    private String date;
    private String hour;

    public OrderDate(){
        this.id = UUID.randomUUID().toString();
        createOrderDate();
        createOrderHour();
    }
    
    private void createOrderDate(){
        LocalDate myDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.date = myDate.format(dateFormatter);
    }   

    private void createOrderHour(){
        LocalTime myHour = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss"); 
        this.hour = myHour.format(timeFormatter);
    }
}