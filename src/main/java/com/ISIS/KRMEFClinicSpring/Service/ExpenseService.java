package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Expense;
import com.ISIS.KRMEFClinicSpring.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;
    public List<Expense> listAllExpense() {
        return expenseRepository.findAll();
    }

    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public Expense getExpense(Integer id) {
        return expenseRepository.findById(id).get();
    }

    public void deleteExpense(Integer id) {
        expenseRepository.deleteById(id);
    }
}
