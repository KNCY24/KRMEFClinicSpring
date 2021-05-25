package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Expense;
import com.ISIS.KRMEFClinicSpring.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    @GetMapping("")
    public List<Expense> list() {
        return expenseService.listAllExpense();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> get(@PathVariable Integer id) {
        try {
            Expense expense = expenseService.getExpense(id);
            return new ResponseEntity<Expense>(expense, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Expense>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Expense expense) {
        expenseService.saveExpense(expense);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Expense expense, @PathVariable Integer id) {
        try {
            Expense existExpense = expenseService.getExpense(id);
            expense.setIdexpense(id);
            expenseService.saveExpense(expense);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        expenseService.deleteExpense(id);
    }
}
