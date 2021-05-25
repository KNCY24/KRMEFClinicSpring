package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Treatment;
import com.ISIS.KRMEFClinicSpring.Service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/treatments")
public class TreatmentController {
    @Autowired
    TreatmentService treatmentService;

    @GetMapping("")
    public List<Treatment> list() {
        return treatmentService.listAllTreatment();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treatment> get(@PathVariable Integer id) {
        try {
            Treatment treatment = treatmentService.getTreatment(id);
            return new ResponseEntity<Treatment>(treatment, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Treatment>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Treatment treatment) {
        treatmentService.saveTreatment(treatment);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Treatment treatment, @PathVariable Integer id) {
        try {
            Treatment existTreatment = treatmentService.getTreatment(id);
            treatment.setIdtreatment(id);
            treatmentService.saveTreatment(treatment);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        treatmentService.deleteTreatment(id);
    }
}
