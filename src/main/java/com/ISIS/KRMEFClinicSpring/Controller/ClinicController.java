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
    AllergyService allergyService;
    @Autowired
    BenefitService benefitService;
    @Autowired
    ChargeService chargeService;
    @Autowired
    ConsultationService consultationService;
    @Autowired
    DependantService dependantService;
    @Autowired
    DetailStockService detailStockService;
    @Autowired
    DiagnosisService diagnosisService;
    @Autowired
    EmergencyService emergencyService;
    @Autowired
    ExpenseService expenseService;
    @Autowired
    FamilyService familyService;
    @Autowired
    HistoryService historyService;
    @Autowired
    MedicineService medicineService;
    @Autowired
    InventoryService inventoryService;
    @Autowired
    ObservationService observationService;
    @Autowired
    PathologyService pathologyService;
    @Autowired
    PatientService patientService;
    @Autowired
    PrescriptionService prescriptionService;
    @Autowired
    ResourceService resourceService;
    @Autowired
    SituationService situationService;
    @Autowired
    TreatmentService treatmentService;
    @Autowired
    UserService userService;

    @GetMapping("/clinic")
    public Clinic getClinic() {
        Clinic clinic = new Clinic();
        clinic.setAllergies(allergyService.listAllAllergy());
        clinic.setBenefits(benefitService.listAllBenefit());
        clinic.setCharges(chargeService.listAllCharge());
        clinic.setConsultations(consultationService.listAllConsultation());
        clinic.setDependants(dependantService.listAllDependant());
        clinic.setDetailstocks(detailStockService.listAllDetailStock());
        clinic.setDiagnosis(diagnosisService.listAllDiagnosis());
        clinic.setEmergencies(emergencyService.listAllEmergency());
        clinic.setExpenses(expenseService.listAllExpense());
        clinic.setFamilies(familyService.listAllFamily());
        clinic.setHistories(historyService.listAllHistory());
        clinic.setMedicines(medicineService.listAllMedicine());
        clinic.setInventories(inventoryService.listAllInventory());
        clinic.setObservations(observationService.listAllObservation());
        clinic.setPathologies(pathologyService.listAllPathology());
        clinic.setPatients(patientService.listAllPatient());
        clinic.setPrescriptions(prescriptionService.listAllPrescription());
        clinic.setResources(resourceService.listAllResource());
        clinic.setSituations(situationService.listAllSituation());
        clinic.setTreatments(treatmentService.listAllTreatment());
        clinic.setUsers(userService.listAllUser());
        return clinic;
    }

    @PutMapping("/addPatient")
    public Clinic update(@RequestBody Clinic clinic) {
        situationService.saveSituation(clinic.getSituations().get(0));
        int idsituation=0;
        int idpatient=0;
        for(Situation situation: situationService.listAllSituation()){
            if(situation == clinic.getSituations().get(0)){
                idsituation = situation.getIdsituation();
                Patient newpatient = clinic.getPatients().get(0);
                newpatient.setIdsituation(idsituation);
                patientService.savePatient(newpatient);
                for(Patient patient : patientService.listAllPatient()){
                    if(patient==newpatient){
                        idpatient = patient.getIdpatient();
                        for(Family family : clinic.getFamilies()){
                            family.setIdpatient(idpatient);
                            familyService.saveFamily(family);
                        }
                        for(Dependant dependant : clinic.getDependants()){
                            dependant.setIdpatient(idpatient);
                            dependantService.saveDependant(dependant);
                        }
                        for(Pathology pathology : clinic.getPathologies()){
                            pathology.setIdpatient(idpatient);
                            pathologyService.savePathology(pathology);
                        }
                        if(clinic.getAllergies().size()>0){
                            allergyService.saveAllergy(clinic.getAllergies().get(0));
                        }
                        for(History history: clinic.getHistories()){
                            history.setIdpatient(idpatient);
                            historyService.saveHistory(history);
                        }
                        for(Charge charge : clinic.getCharges()){
                            charge.setIdpatient(idpatient);
                            chargeService.saveCharge(charge);
                        }
                        for(Resource resource : clinic.getResources()){
                            resource.setIdpatient(idpatient);
                            resourceService.saveResource(resource);
                        }
                    }
                }
            }
        }

        return getClinic();
    }
}
