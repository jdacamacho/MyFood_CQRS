package com.unicauca.my_food.infrastucture.MySQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.my_food.infrastucture.MySQL.entities.OrderEntity;

@Repository
public interface OrderMySqlRepository extends JpaRepository<OrderEntity, String>{
    
}
