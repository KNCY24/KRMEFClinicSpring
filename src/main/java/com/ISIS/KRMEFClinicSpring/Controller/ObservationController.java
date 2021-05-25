package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Observation;
import com.ISIS.KRMEFClinicSpring.Service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/observations")
public class ObservationController {
    @Autowired
    ObservationService observationService;

    @GetMapping("")
    public List<Observation> list() {
        return observationService.listAllObservation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Observation> get(@PathVariable Integer id) {
        try {
            Observation observation = observationService.getObservation(id);
            return new ResponseEntity<Observation>(observation, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Observation>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Observation observation) {
        observationService.saveObservation(observation);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Observation observation, @PathVariable Integer id) {
        try {
            Observation existObservation = observationService.getObservation(id);
            observation.setIdobservation(id);
            observationService.saveObservation(observation);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        observationService.deleteObservation(id);
    }
}
