package com.unicauca.my_food.domain.waste.value_objects;

import java.util.UUID;

import lombok.Getter;

@Getter
public class QuantityWaste {
    private String id;
    private double wasteQuantity;
    private double totalWasteQuantity;

    public QuantityWaste(double wasteQuantity) {
        this.id = UUID.randomUUID().toString();
        this.wasteQuantity = wasteQuantity;
        this.totalWasteQuantity = wasteQuantity;
    }

    public boolean addQuantity(double quantity){
        if(quantity <= 0)
            return false;
        this.totalWasteQuantity += quantity;
        return true;
    }

    public boolean validatePositive(){
        return this.wasteQuantity > 0;
    }

    public boolean reduceQuantity(double quantity){
        if(quantity < 0 || this.totalWasteQuantity - quantity <0){
            return false;
        }
        this.totalWasteQuantity -= quantity;
        return true;
    }

    public boolean isPositive(){
        return this.totalWasteQuantity > 0;
    }
}
