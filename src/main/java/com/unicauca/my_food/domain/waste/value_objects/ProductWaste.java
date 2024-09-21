package com.unicauca.my_food.domain.waste.value_objects;

import java.util.UUID;

import com.unicauca.my_food.domain.inventory.Product;

import lombok.Getter;

    @Getter
    public class ProductWaste {
        private String productWasteId;
        private Product product;

        public ProductWaste(Product product){
            this.productWasteId = UUID.randomUUID().toString();
            this.product = product;
        }
        
        public String detailsProduct(){
            return String.format("ID: %s, Nombre: %s, Categoria: %s, Stock %d",
                                        product.getId(), 
                                        product.getName().getName(), 
                                        product.getCategory(),
                                        product.getStock().getAmount());
        }
    }
