package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Prescription;
import com.ISIS.KRMEFClinicSpring.Service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {
    @Autowired
    PrescriptionService prescriptionService;

    @GetMapping("")
    public List<Prescription> list() {
        return prescriptionService.listAllPrescription();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> get(@PathVariable Integer id) {
        try {
            Prescription prescription = prescriptionService.getPrescription(id);
            return new ResponseEntity<Prescription>(prescription, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Prescription>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Prescription prescription) {
        prescriptionService.savePrescription(prescription);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Prescription prescription, @PathVariable Integer id) {
        try {
            Prescription existPrescription = prescriptionService.getPrescription(id);
            prescription.setIdprescription(id);
            prescriptionService.savePrescription(prescription);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        prescriptionService.deletePrescription(id);
    }
}
