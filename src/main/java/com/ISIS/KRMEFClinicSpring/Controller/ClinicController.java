package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.*;
import com.ISIS.KRMEFClinicSpring.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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

    @PutMapping("/sellMedicine")
    public Clinic sellMedicine(@RequestBody Medicine newmedicine) {
        for(Medicine medicine:medicineService.listAllMedicine()){
            if(medicine.getIdmedicine()==newmedicine.getIdmedicine()){
                medicine.setQuantity(newmedicine.getQuantity());
                medicine.getVentes().addAll(newmedicine.getVentes());
                medicine.getDetailstock().setQuantity(newmedicine.getDetailstock().getQuantity());
                medicine.getDetailstock().setMore(newmedicine.getDetailstock().getMore());
            }
        }
        return getClinic();
    }


    @PutMapping("/addMedicine")
    public Clinic addMedicine(@RequestBody Medicine newmedicine) {
        boolean medicineExist = false;
        boolean inventoryExist = false;
        Medicine med = new Medicine();
        if(medicineService.listAllMedicine().size()>0){
            for(Medicine medicine : medicineService.listAllMedicine()) {
                if (medicine.getName().equals(newmedicine.getName()) && medicine.getPackaging().equals(newmedicine.getPackaging()) && medicine.getDetailstock().getPackaging().equals(newmedicine.getDetailstock().getPackaging()) && medicine.getDetailstock().getQuantity() == newmedicine.getDetailstock().getQuantity() && medicine.getSource().equals(newmedicine.getSource()) && medicine.getRetailprice() == newmedicine.getRetailprice() && medicine.getExpiration().getYear() == newmedicine.getExpiration().getYear() && medicine.getExpiration().getMonth() == newmedicine.getExpiration().getMonth() && medicine.getExpiration().getDate() == newmedicine.getExpiration().getDate()) {
                    medicineExist = true;
                    med = medicine;
                }else if(medicine.getName().equals(newmedicine.getName()) && medicine.getSource().equals(newmedicine.getSource())){
                    inventoryExist=true;
                }
            }
        }
        if(medicineExist == true){
            med.setQuantity(med.getQuantity()+ newmedicine.getQuantity());
            for(Expense expense : newmedicine.getAchats()){
                med.getAchats().add(expense);
            }
        }else{
            medicineService.saveMedicine(newmedicine);
            if(inventoryExist==false) {
                Inventory inventory = new Inventory();
                inventory.setName(newmedicine.getName());
                inventory.setSource(newmedicine.getSource());
                inventoryService.saveInventory(inventory);
            }
        }
        return getClinic();
    }

    @PutMapping("/deleteDrug")
    public Clinic deleteDrug(@RequestBody int id){
        Medicine medicine = medicineService.getMedicine(id);
        medicine.setQuantity(0);
        medicine.setRetailprice(0);
        medicine.setSource("");
        medicine.getDetailstock().setQuantity(0);
        medicine.getDetailstock().setMore(0);
        return getClinic();
    }
}
