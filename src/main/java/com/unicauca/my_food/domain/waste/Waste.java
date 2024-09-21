package com.unicauca.my_food.domain.waste;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.unicauca.my_food.domain.inventory.Product;
import com.unicauca.my_food.domain.waste.constants.CauseWasteConstants;
import com.unicauca.my_food.domain.waste.value_objects.CauseWaste;
import com.unicauca.my_food.domain.waste.value_objects.QuantityWaste;

import lombok.Getter;

@Getter
public class Waste {
    private String idWaste;
    private String productId;
    private QuantityWaste quantityWaste;
    private CauseWaste cause;
    private Date dateRegister; 
    private List<Product> productsWaste;

    public Waste(Product product, double initialQuantityWaste, CauseWaste cause){
        this.idWaste = UUID.randomUUID().toString();
        this.productId = product.getId();
        this.quantityWaste = new QuantityWaste(initialQuantityWaste);
        this.cause = cause;
        this.dateRegister = new Date();
        this.productsWaste = new ArrayList<>();
    }

    public void registerWaste(double quantity){
        if(quantity > 0)
            this.quantityWaste.addQuantity(quantity);
        else
            throw new IllegalArgumentException("La cantidad de desperdicio debe ser positiva.");
    }

    public String suggestReductionMeasures() {
        StringBuilder suggestions = new StringBuilder();
        double totalWaste = this.quantityWaste.getTotalWasteQuantity();
        if (totalWaste > 75) 
            suggestions.append("Reducción sugerida: La cantidad de desperdicio es extremadamente alta. Reevalúa la planificación.\n");
        else if (totalWaste > 50)
            suggestions.append("Reducción sugerida: Revisa los procedimientos para evitar sobrepreparación o mal almacenamiento.\n");
        else if (totalWaste > 25) 
            suggestions.append("Reducción sugerida: Podría ser necesario ajustar la gestión del inventario y las porciones.\n");
        else 
            suggestions.append("Reducción sugerida: El nivel de desperdicio es bajo, sigue con las buenas prácticas.\n");

        String causeDescription = this.cause.getDescription();
        String suggestion = CauseWasteConstants.CAUSE_SUGGESTIONS.getOrDefault(causeDescription, "Sugerencia: Analiza más a fondo las causas para proponer acciones correctivas.");
        suggestions.append(suggestion).append("\n");

        return suggestions.toString();
    }
}


