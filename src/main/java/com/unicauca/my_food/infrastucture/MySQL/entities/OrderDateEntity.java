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
@Table(name = "order_dates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDateEntity {
    @Id
    private String id_date;
    private String date;
    private String hour;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
    private OrderEntity objOrder;
}
