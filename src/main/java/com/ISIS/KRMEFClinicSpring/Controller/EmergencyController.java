package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Emergency;
import com.ISIS.KRMEFClinicSpring.Service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/emergencies")
public class EmergencyController {
    @Autowired
    EmergencyService emergencyService;

    @GetMapping("")
    public List<Emergency> list() {
        return emergencyService.listAllEmergency();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emergency> get(@PathVariable Integer id) {
        try {
            Emergency emergency = emergencyService.getEmergency(id);
            return new ResponseEntity<Emergency>(emergency, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Emergency>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Emergency emergency) {
        emergencyService.saveEmergency(emergency);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Emergency emergency, @PathVariable Integer id) {
        try {
            Emergency existEmergency = emergencyService.getEmergency(id);
            emergency.setIdemergency(id);
            emergencyService.saveEmergency(emergency);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        emergencyService.deleteEmergency(id);
    }
}
