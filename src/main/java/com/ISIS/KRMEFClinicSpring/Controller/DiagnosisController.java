package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Diagnosis;
import com.ISIS.KRMEFClinicSpring.Service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {
    @Autowired
    DiagnosisService diagnosisService;

    @GetMapping("")
    public List<Diagnosis> list() {
        return diagnosisService.listAllDiagnosis();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diagnosis> get(@PathVariable Integer id) {
        try {
            Diagnosis diagnosis = diagnosisService.getDiagnosis(id);
            return new ResponseEntity<Diagnosis>(diagnosis, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Diagnosis>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Diagnosis diagnosis) {
        diagnosisService.saveDiagnosis(diagnosis);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Diagnosis diagnosis, @PathVariable Integer id) {
        try {
            Diagnosis existDiagnosis = diagnosisService.getDiagnosis(id);
            diagnosis.setIddiagnosis(id);
            diagnosisService.saveDiagnosis(diagnosis);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        diagnosisService.deleteDiagnosis(id);
    }
}
