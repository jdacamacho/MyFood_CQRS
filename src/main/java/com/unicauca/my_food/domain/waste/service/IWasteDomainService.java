package com.unicauca.my_food.domain.waste.service;

import com.unicauca.my_food.domain.inventory.Product;
import com.unicauca.my_food.domain.waste.Waste;
import com.unicauca.my_food.domain.waste.value_objects.CauseWaste;
import com.unicauca.my_food.domain.waste.value_objects.ProductWaste;

public interface IWasteDomainService {
    
    public boolean registerWaste(Waste waste);
    public String suggestReductionMeasures(Waste waste);
    public boolean addQuantity (Waste waste, double quantity);
    public boolean reduceQuantity (Waste waste, double quantity);
    public String getDetailsProduct(ProductWaste product);
    public String selectCause(CauseWaste cause, int causeIndex);
    public boolean isValidCause(CauseWaste cause);
}
