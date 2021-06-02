package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.*;
import com.ISIS.KRMEFClinicSpring.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/generic")
public class ClinicController {
    @Autowired
    BenefitService benefitService;
    @Autowired
    ExpenseService expenseService;
    @Autowired
    MedicineService medicineService;
    @Autowired
    InventoryService inventoryService;
    @Autowired
    PatientService patientService;
    @Autowired
    UserService userService;

    @GetMapping("/clinic")
    public Clinic getClinic() {
        Clinic clinic = new Clinic();
        clinic.setBenefits(benefitService.listAllBenefit());
        clinic.setExpenses(expenseService.listAllExpense());
        clinic.setMedicines(medicineService.listAllMedicine());
        clinic.setPatients(patientService.listAllPatient());
        clinic.setInventories(inventoryService.listAllInventory());
        clinic.setUsers(userService.listAllUser());
        return clinic;
    }

    @PutMapping("/addPatient")
    public Clinic addPatient(@RequestBody Patient patient) {
        patientService.savePatient(patient);
        return getClinic();
    }

    @PutMapping("/deleteDrug")
    public Clinic deleteDrug(@RequestBody int id){
        Medicine medicine = medicineService.getMedicine(id);
        medicine.setQuantity(0);
        medicine.setRetailprice(0);
        medicine.setSource("");
        medicine.getdetailstock().setQuantity(0);
        medicine.getdetailstock().setRemarks("");
        return getClinic();
    }
}
