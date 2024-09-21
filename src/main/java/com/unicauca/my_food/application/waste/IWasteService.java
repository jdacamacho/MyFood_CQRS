package com.unicauca.my_food.application.waste;

import java.util.List;

import com.unicauca.my_food.domain.waste.Waste;
import com.unicauca.my_food.domain.waste.value_objects.CauseWaste;
import com.unicauca.my_food.domain.waste.value_objects.ProductWaste;

public interface IWasteService {
    public Waste createWaste(Waste waste);
    public Waste getWasteById(String wasteId);
    public List<Waste> getAllWaste();
    public void updateWaste(String wasteId, Waste waste);
    public void deleteWaste(String wasteId);
    public void registerWaste(String wasteId, double quantity);
    void suggestReductionMeasures(String wasteId);
    public String getDetailsProduct(ProductWaste product);
    public String selectCause(CauseWaste cause, int causeIndex);
    public boolean isValidCause(CauseWaste cause);
}
