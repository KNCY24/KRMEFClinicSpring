package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Family;
import com.ISIS.KRMEFClinicSpring.Service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/families")
public class FamilyController {
    @Autowired
    FamilyService familyService;

    @GetMapping("")
    public List<Family> list() {
        return familyService.listAllFamily();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Family> get(@PathVariable Integer id) {
        try {
            Family family = familyService.getFamily(id);
            return new ResponseEntity<Family>(family, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Family>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Family family) {
        familyService.saveFamily(family);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Family family, @PathVariable Integer id) {
        try {
            Family existFamily = familyService.getFamily(id);
            family.setIdfamily(id);
            familyService.saveFamily(family);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        familyService.deleteFamily(id);
    }
}
