package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.*;
import com.ISIS.KRMEFClinicSpring.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    ConsultationService consultationService;

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

    @PutMapping("/addUser")
    public Clinic addUser(@RequestBody User user) {
        userService.saveUser(user);
        return getClinic();
    }

    @PutMapping("/deleteUser")
    public Clinic deleteUser(@RequestBody int iduser) {
        userService.deleteUser(iduser);
        return getClinic();
    }

    @PutMapping("/updateUser")
    public Clinic updateUser(@RequestBody User newuser) {
        for(User user : userService.listAllUser()){
            if(user.getIduser()==newuser.getIduser()){
                user.setDate(newuser.getDate());
                user.setName(newuser.getName());
                user.setRole(newuser.getRole());
                user.setSexe(newuser.getSexe());
                user.setUsername(newuser.getUsername());
            }
        }
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

    @PutMapping("/addConsultation")
    public Clinic addConsultation(@RequestBody Patient newpatient) {
        for(Patient patient : patientService.listAllPatient()){
            if(newpatient.getIdpatient()==patient.getIdpatient()){
                for(Consultation consultation: newpatient.getConsultations()){
                    patient.getConsultations().add(consultation);
                }
            }
        }
        return getClinic();
    }

    @PutMapping("/deleteConsultation")
    public Clinic deleteConsultation(@RequestBody int idconsultation) {
        consultationService.deleteConsultation(idconsultation);
        return getClinic();
    }

    @PutMapping("/deletePayment")
    public Clinic deletePayment(@RequestBody int idpayment) {
        benefitService.deleteBenefit(idpayment);
        return getClinic();
    }

    @PutMapping("/payDebt")
    public Clinic payDebt(@RequestBody Benefit updateBenefit) {
        for(Benefit benefit :benefitService.listAllBenefit()){
            if(benefit.getIdbenefit()==updateBenefit.getIdbenefit()){
                benefit.setDue(updateBenefit.getDue());
            }
        }
        return getClinic();
    }


    @PutMapping("/addTreatment")
    public Clinic addTreatment(@RequestBody Patient newpatient) {
        for(Patient patient : patientService.listAllPatient()){
            if(newpatient.getIdpatient()==patient.getIdpatient()){
                for(Treatment treatment: newpatient.getTreatments()){
                    patient.getTreatments().add(treatment);
                }
            }
        }
        return getClinic();
    }
}
