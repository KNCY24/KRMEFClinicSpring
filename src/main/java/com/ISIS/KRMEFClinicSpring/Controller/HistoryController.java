package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.History;
import com.ISIS.KRMEFClinicSpring.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/histories")
public class HistoryController {
    @Autowired
    HistoryService historyService;

    @GetMapping("")
    public List<History> list() {
        return historyService.listAllHistory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<History> get(@PathVariable Integer id) {
        try {
            History history = historyService.getHistory(id);
            return new ResponseEntity<History>(history, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<History>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody History history) {
        historyService.saveHistory(history);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody History history, @PathVariable Integer id) {
        try {
            History existHistory = historyService.getHistory(id);
            history.setIdhistory(id);
            historyService.saveHistory(history);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        historyService.deleteHistory(id);
    }
}
