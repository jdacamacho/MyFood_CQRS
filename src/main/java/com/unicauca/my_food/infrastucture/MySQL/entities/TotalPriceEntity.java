package com.unicauca.my_food.infrastucture.MySQL.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "total_prices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalPriceEntity {
    @Id
    private String id_total_price;
    private double totalPrice;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
    private OrderEntity objOrder;
}
