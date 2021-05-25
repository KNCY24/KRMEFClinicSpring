package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Dependant;
import com.ISIS.KRMEFClinicSpring.Service.DependantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/dependants")
public class DependantController {
    @Autowired
    DependantService dependantService;

    @GetMapping("")
    public List<Dependant> list() {
        return dependantService.listAllDependant();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dependant> get(@PathVariable Integer id) {
        try {
            Dependant dependant = dependantService.getDependant(id);
            return new ResponseEntity<Dependant>(dependant, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Dependant>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Dependant dependant) {
        dependantService.saveDependant(dependant);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Dependant dependant, @PathVariable Integer id) {
        try {
            Dependant existDependant = dependantService.getDependant(id);
            dependant.setIddependant(id);
            dependantService.saveDependant(dependant);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        dependantService.deleteDependant(id);
    }
}
