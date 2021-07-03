package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.*;
import com.ISIS.KRMEFClinicSpring.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/generic")
public class ClinicController {
    @Autowired
    BenefitService benefitService;
    @Autowired
    ExpenseService expenseService;
    @Autowired
    MedicineService medicineService;
    @Autowired
    PatientService patientService;
    @Autowired
    UserService userService;
    @Autowired
    ConsultationService consultationService;
    @Autowired
    TreatmentService treatmentService;
    @Autowired
    ChargeService chargeService;
    @Autowired
    EmergencyService emergencyService;
    @Autowired
    DependantService dependantService;
    @Autowired
    FamilyService familyService;
    @Autowired
    ResourceService resourceService;
    @Autowired
    PathologyService pathologyService;
    @Autowired
    HistoryService historyService;

    @GetMapping("/clinic")
    public Clinic getClinic() {
        Clinic clinic = new Clinic();
        clinic.setBenefits(benefitService.listAllBenefit());
        clinic.setExpenses(expenseService.listAllExpense());
        clinic.setMedicines(medicineService.listAllMedicine());
        clinic.setPatients(patientService.listAllPatient());
        clinic.setUsers(userService.listAllUser());
        return clinic;
    }

    @PutMapping("/updatePw")
    public Clinic updatePw(@RequestBody User newuser) {
        for(User user : userService.listAllUser()){
            if(user.getIduser()== newuser.getIduser()){
                user.setPassword(newuser.getPassword());
                user.setFirstpw(false);
            }
        }
        return  getClinic();
    }

    @PutMapping("/addPatient")
    public Clinic addPatient(@RequestBody Patient patient) {
        patientService.savePatient(patient);
        return getClinic();
    }

    @PutMapping("/updatePatient")
    public Clinic updatePatient(@RequestBody Patient newpatient) {
        for(Patient patient : patientService.listAllPatient()){
            if(patient.getIdpatient()==newpatient.getIdpatient()){
                patient.setName(newpatient.getName());
                patient.setAddress(newpatient.getAddress());
                patient.setBirthlocation(newpatient.getBirthlocation());
                patient.setDate(newpatient.getDate());
                patient.setCategory(newpatient.getCategory());
                patient.setIduser(newpatient.getIduser());
                patient.setPhone(newpatient.getPhone());
                patient.setRemarks(newpatient.getRemarks());
                patient.setSexe(newpatient.getSexe());
                patient.setOccupation(newpatient.getOccupation());


                patient.getAllergy().setName(newpatient.getAllergy().getName());

                patient.getSituation().setTypesituation(newpatient.getSituation().getTypesituation());
                patient.getSituation().setOccupation(newpatient.getSituation().getOccupation());
                patient.getSituation().setRemarks(newpatient.getSituation().getRemarks());

                patient.getCharges().clear();
                for(Charge charge: newpatient.getCharges()){
                    patient.getCharges().add(charge);
                }

                patient.getEmergencies().clear();
                for(Emergency emergency : newpatient.getEmergencies()){
                    patient.getEmergencies().add(emergency);
                }

                patient.getDependants().clear();
                for(Dependant dependant: newpatient.getDependants()){
                    patient.getDependants().add(dependant);
                }

                patient.getFamilies().clear();
                for(Family family: newpatient.getFamilies()){
                    patient.getFamilies().add(family);
                }

                patient.getHistories().clear();
                for(History history: newpatient.getHistories()){
                    patient.getHistories().add(history);
                }

                patient.getPathologies().clear();
                for(Pathology pathology: newpatient.getPathologies()){
                    patient.getPathologies().add(pathology);
                }

                patient.getResources().clear();
                for(Resource resource: newpatient.getResources()){
                    patient.getResources().add(resource);
                }

            }
        }
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
            med.getDetailstock().setMore(med.getDetailstock().getMore()+newmedicine.getDetailstock().getMore());
            for(Expense expense : newmedicine.getAchats()){
                med.getAchats().add(expense);
            }
        }else{
            medicineService.saveMedicine(newmedicine);
        }
        return getClinic();
    }

    @PutMapping("/emptyMedicine")
    public Clinic emptyMedicine(@RequestBody int id){
        Medicine medicine = medicineService.getMedicine(id);
        medicine.setQuantity(0);
        medicine.getDetailstock().setQuantity(0);
        medicine.getDetailstock().setMore(0);
        return getClinic();
    }

    @PutMapping("/deleteMedicine")
    public Clinic deleteMedicine(@RequestBody int id){
        medicineService.deleteMedicine(id);
        return getClinic();
    }

    @PutMapping("/updateMedicine")
    public Clinic updateMedicine(@RequestBody Medicine newmedicine){
        for(Medicine medicine : medicineService.listAllMedicine()){
            if(medicine.getIdmedicine()== newmedicine.getIdmedicine()){
                medicine.setName(newmedicine.getName());
                medicine.setSource(newmedicine.getSource());
                medicine.setExpiration(newmedicine.getExpiration());
            }
        }
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
        Consultation c = new Consultation();
        Patient p = new Patient();
        for(Patient patient : patientService.listAllPatient()){
            for(Consultation consultation : patient.getConsultations()){
                if(consultation.getIdconsultation()==idconsultation){
                    c = consultation;
                    p = patient;
                }
            }
        }
        p.getConsultations().remove(c);
        //consultationService.deleteConsultation(idconsultation);
        return getClinic();
    }

    @PutMapping("/deletePayment")
    public Clinic deletePayment(@RequestBody int idpayment) {
        Medicine med = new Medicine();
        Benefit ben= new Benefit();
        for(Medicine medicine:medicineService.listAllMedicine()){
            for(Benefit benefit:medicine.getVentes()){
                if(benefit.getIdbenefit()==idpayment){
                    med=medicine;
                    ben=benefit;
                    if(medicine.getPackaging().equals(benefit.getPackaging())){
                        System.out.println("1"+benefit.getPackaging());
                        medicine.setQuantity(medicine.getQuantity()+ benefit.getQuantity());
                    }else{
                        if(benefit.getQuantity()< medicine.getDetailstock().getQuantity()){
                            System.out.println("2");
                            medicine.getDetailstock().setMore(medicine.getDetailstock().getMore()+benefit.getQuantity());
                        }else if(benefit.getQuantity()== medicine.getDetailstock().getQuantity()){
                            System.out.println("3");
                            medicine.setQuantity(medicine.getQuantity()+1);
                        }else{
                            while(benefit.getQuantity()>=medicine.getDetailstock().getQuantity()){
                                benefit.setQuantity(benefit.getQuantity()-medicine.getDetailstock().getQuantity());
                                System.out.println("4"+benefit.getQuantity());
                                System.out.println("5"+medicine.getQuantity());
                                medicine.setQuantity(medicine.getQuantity()+1);
                            }
                            if(benefit.getQuantity()!=0){
                                System.out.println("6");
                                medicine.getDetailstock().setMore(benefit.getQuantity());
                            }
                        }
                        while(medicine.getDetailstock().getMore()>= medicine.getDetailstock().getQuantity()){
                            System.out.println("7");
                            medicine.getDetailstock().setMore(medicine.getDetailstock().getMore()-medicine.getDetailstock().getQuantity());
                            medicine.setQuantity(medicine.getQuantity()+1
                            );
                        }
                    }
                }
            }
        }
        med.getVentes().remove(ben);
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

    @PutMapping("/deleteTreatment")
    public Clinic deleteTreatment(@RequestBody int idtreatment) {
        treatmentService.deleteTreatment(idtreatment);
        return getClinic();
    }

    @PutMapping("/updateTreatment")
    public Clinic updateTreatment(@RequestBody Treatment newtreatment) {
        for(Treatment treatment : treatmentService.listAllTreatment()){
            if(treatment.getIdtreatment()==newtreatment.getIdtreatment()){
                treatment.setDeadline(newtreatment.getDeadline());
                treatment.setRemarks(newtreatment.getRemarks());
            }
        }
        return getClinic();
    }
}
