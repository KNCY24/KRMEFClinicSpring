package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Benefit;
import com.ISIS.KRMEFClinicSpring.Service.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/benefits")
public class BenefitController {
    @Autowired
    BenefitService benefitService;

    @GetMapping("")
    public List<Benefit> list() {
        return benefitService.listAllBenefit();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Benefit> get(@PathVariable Integer id) {
        try {
            Benefit benefit = benefitService.getBenefit(id);
            return new ResponseEntity<Benefit>(benefit, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Benefit>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Benefit benefit) {
        benefitService.saveBenefit(benefit);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Benefit benefit, @PathVariable Integer id) {
        try {
            Benefit existBenefit = benefitService.getBenefit(id);
            benefit.setIdbenefit(id);
            benefitService.saveBenefit(benefit);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        benefitService.deleteBenefit(id);
    }
}
