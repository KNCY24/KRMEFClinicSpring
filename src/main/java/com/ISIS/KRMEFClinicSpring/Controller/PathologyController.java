package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Pathology;
import com.ISIS.KRMEFClinicSpring.Service.PathologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/pathologies")
public class PathologyController {
    @Autowired
    PathologyService pathologyService;

    @GetMapping("")
    public List<Pathology> list() {
        return pathologyService.listAllPathology();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pathology> get(@PathVariable Integer id) {
        try {
            Pathology pathology = pathologyService.getPathology(id);
            return new ResponseEntity<Pathology>(pathology, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Pathology>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Pathology pathology) {
        pathologyService.savePathology(pathology);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Pathology pathology, @PathVariable Integer id) {
        try {
            Pathology existPathology = pathologyService.getPathology(id);
            pathology.setIdpathology(id);
            pathologyService.savePathology(pathology);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        pathologyService.deletePathology(id);
    }
}
