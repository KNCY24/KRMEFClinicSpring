package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Medicine;
import com.ISIS.KRMEFClinicSpring.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
    @Autowired
    MedicineService medicineService;

    @GetMapping("")
    public List<Medicine> list() {
        return medicineService.listAllMedicine();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> get(@PathVariable Integer id) {
        try {
            Medicine medicine = medicineService.getMedicine(id);
            return new ResponseEntity<Medicine>(medicine, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Medicine>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Medicine medicine) {
        medicineService.saveMedicine(medicine);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Medicine medicine, @PathVariable Integer id) {
        try {
            Medicine existMedicine = medicineService.getMedicine(id);
            medicine.setIdmedicine(id);
            medicineService.saveMedicine(medicine);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        medicineService.deleteMedicine(id);
    }
}
