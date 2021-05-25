package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.DetailStock;
import com.ISIS.KRMEFClinicSpring.Service.DetailStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/detailstocks")
public class DetailStockController {
    @Autowired
    DetailStockService detailStockService;

    @GetMapping("")
    public List<DetailStock> list() {
        return detailStockService.listAllDetailStock();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailStock> get(@PathVariable Integer id) {
        try {
            DetailStock detailStock = detailStockService.getDetailStock(id);
            return new ResponseEntity<DetailStock>(detailStock, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DetailStock>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody DetailStock detailStock) {
        detailStockService.saveDetailStock(detailStock);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody DetailStock detailStock, @PathVariable Integer id) {
        try {
            DetailStock existDetailStock = detailStockService.getDetailStock(id);
            detailStock.setIddetailstock(id);
            detailStockService.saveDetailStock(detailStock);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        detailStockService.deleteDetailStock(id);
    }
}
