package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Inventory;
import com.ISIS.KRMEFClinicSpring.Model.Medicine;
import com.ISIS.KRMEFClinicSpring.Repository.InventoryRepository;
import com.ISIS.KRMEFClinicSpring.Repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    public List<Inventory> listAllInventory() {
        return inventoryRepository.findAll();
    }

    public void saveInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    public Inventory getInventory(Integer id) {
        return inventoryRepository.findById(id).get();
    }

    public void deleteInventory(Integer id) {
        inventoryRepository.deleteById(id);
    }
}
