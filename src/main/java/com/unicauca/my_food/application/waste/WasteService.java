package com.unicauca.my_food.application.waste;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unicauca.my_food.domain.waste.Waste;
import com.unicauca.my_food.domain.waste.service.WasteDomainService;
import com.unicauca.my_food.domain.waste.value_objects.CauseWaste;
import com.unicauca.my_food.domain.waste.value_objects.ProductWaste;
import com.unicauca.my_food.infrastucture.exceptionHandler.ownException.ObjectNotFoundException;
import com.unicauca.my_food.infrastucture.exceptionHandler.ownException.ObjectNullException;
import com.unicauca.my_food.infrastucture.repositories.WasteRepository;

@Service
public class WasteService implements IWasteService{
    private final WasteDomainService domainService;
    private final WasteRepository repository;

    public WasteService(WasteDomainService domainService, WasteRepository repository){
        this.repository = repository;
        this.domainService = domainService;
    }

    @Override
    public Waste createWaste(Waste waste) {
        this.repository.save(waste);
        return waste;
    }

    @Override
    public Waste getWasteById(String wasteId) {
        Waste waste = this.repository.findById(wasteId);
        if(waste == null) 
            throw new ObjectNullException("Waste is null...");

        return waste;
    }

    @Override
    public List<Waste> getAllWaste() {
        return this.repository.findAll();
    }

    @Override
    public void updateWaste(String wasteId, Waste waste) {
        Waste existingWaste = this.repository.findById(wasteId);
        if(existingWaste == null)
            throw new ObjectNotFoundException("Waste not found...");

        this.repository.update(wasteId, waste);
    }

    @Override
    public void deleteWaste(String wasteId) {
        Waste waste = this.repository.findById(wasteId);
        if(waste == null)
            throw new ObjectNotFoundException("Waste not found...");

        this.repository.delete(wasteId);       
    }

    @Override
    public void registerWaste(String wasteId, double quantity) {
        Waste waste = this.repository.findById(wasteId);
        if(waste == null)
            throw new ObjectNotFoundException("Waste not found...");

        this.domainService.addQuantity(waste, quantity);
    }

    @Override
    public void suggestReductionMeasures(String wasteId) {
        Waste waste = this.repository.findById(wasteId);
        if(waste == null)
            throw new ObjectNotFoundException("Waste not found...");

        this.domainService.suggestReductionMeasures(waste);
    }

    @Override
    public String getDetailsProduct(ProductWaste product) {
        if(product == null)
            throw new ObjectNotFoundException("Waste not found...");

        return this.domainService.getDetailsProduct(product);
    }

    @Override
    public String selectCause(CauseWaste cause, int causeIndex) {
        if(cause == null) 
            throw new ObjectNotFoundException("Waste not found...");

        return this.domainService.selectCause(cause, causeIndex);
    }

    @Override
    public boolean isValidCause(CauseWaste cause) {
        if (cause == null) {
            throw new ObjectNotFoundException("CauseWaste is null");
        }
        return this.domainService.isValidCause(cause);
    }
    
}
