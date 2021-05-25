package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Charge;
import com.ISIS.KRMEFClinicSpring.Service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/charges")
public class ChargeController {
    @Autowired
    ChargeService chargeService;

    @GetMapping("")
    public List<Charge> list() {
        return chargeService.listAllCharge();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Charge> get(@PathVariable Integer id) {
        try {
            Charge charge = chargeService.getCharge(id);
            return new ResponseEntity<Charge>(charge, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Charge>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Charge charge) {
        chargeService.saveCharge(charge);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Charge charge, @PathVariable Integer id) {
        try {
            Charge existCharge = chargeService.getCharge(id);
            charge.setIdcharge(id);
            chargeService.saveCharge(charge);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        chargeService.deleteCharge(id);
    }
}
