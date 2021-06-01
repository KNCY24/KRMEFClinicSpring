package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Inventory;
import com.ISIS.KRMEFClinicSpring.Model.Medicine;
import com.ISIS.KRMEFClinicSpring.Service.InventoryService;
import com.ISIS.KRMEFClinicSpring.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/inventories")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping("")
    public List<Inventory> list() {
        return inventoryService.listAllInventory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> get(@PathVariable Integer id) {
        try {
            Inventory inventory = inventoryService.getInventory(id);
            return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Inventory inventory) {
        inventoryService.saveInventory(inventory);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Inventory inventory, @PathVariable Integer id) {
        try {
            Inventory existInventory = inventoryService.getInventory(id);
            inventory.setIdinventory(id);
            inventoryService.saveInventory(inventory);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        inventoryService.deleteInventory(id);
    }
}
