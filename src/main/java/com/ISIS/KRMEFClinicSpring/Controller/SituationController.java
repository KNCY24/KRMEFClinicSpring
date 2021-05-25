package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Situation;
import com.ISIS.KRMEFClinicSpring.Service.SituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/situations")
public class SituationController {
    @Autowired
    SituationService situationService;

    @GetMapping("")
    public List<Situation> list() {
        return situationService.listAllSituation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Situation> get(@PathVariable Integer id) {
        try {
            Situation situation = situationService.getSituation(id);
            return new ResponseEntity<Situation>(situation, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Situation>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Situation situation) {
        situationService.saveSituation(situation);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Situation situation, @PathVariable Integer id) {
        try {
            Situation existSituation = situationService.getSituation(id);
            situation.setIdsituation(id);
            situationService.saveSituation(situation);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        situationService.deleteSituation(id);
    }
}
