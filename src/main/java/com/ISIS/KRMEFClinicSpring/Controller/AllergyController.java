package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Allergy;
import com.ISIS.KRMEFClinicSpring.Service.AllergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/allergies")
public class AllergyController {
    @Autowired
    AllergyService allergyService;

    @GetMapping("")
    public List<Allergy> list() {
        return allergyService.listAllAllergy();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Allergy> get(@PathVariable Integer id) {
        try {
            Allergy allergy = allergyService.getAllergy(id);
            return new ResponseEntity<Allergy>(allergy, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Allergy>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Allergy allergy) {
        allergyService.saveAllergy(allergy);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Allergy allergy, @PathVariable Integer id) {
        try {
            Allergy existAllergy = allergyService.getAllergy(id);
            allergy.setIdallergy(id);
            allergyService.saveAllergy(allergy);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        allergyService.deleteAllergy(id);
    }
}
