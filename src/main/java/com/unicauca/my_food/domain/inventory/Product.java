package com.unicauca.my_food.domain.inventory;

import java.util.Date;
import java.util.Locale.Category;

import com.unicauca.my_food.domain.inventory.service.IProduct;
import com.unicauca.my_food.domain.inventory.value_objects.ProductName;
import com.unicauca.my_food.domain.inventory.value_objects.Stock;
import com.unicauca.my_food.domain.inventory.value_objects.Units;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product implements IProduct {
    private String id;
    private ProductName name;
    private Category category;
    private Stock stock;
    private Units unit;
    private Date usefulLife;
    private boolean isExpired;

    @Override
    public boolean decreaseStock(int amount) {
        // Calcula la nueva cantidad
        amount = this.stock.getAmount() - amount;
        // Determina si es válida la nueva cantidad.
        if (amount < 0)
            return false;
        // Actualiza el inventario
        this.stock = new Stock(amount);
        return true;
    }

    @Override
    public boolean markExpired() {
        // Determina si esta vencido el producto
        this.isExpired = this.usefulLife.after(new Date());
        return isExpired;
    }

    @Override
    public boolean increaseStock(int amount) {
        // Verifica que la cantidad a ingresar sea válida.
        if (amount <= 0)
            return false;
        // Calcula la nueva cantidad
        amount += this.stock.getAmount();
        // Actualiza la nueva cantidad
        this.stock = new Stock(amount);
        return true;
    }

}
