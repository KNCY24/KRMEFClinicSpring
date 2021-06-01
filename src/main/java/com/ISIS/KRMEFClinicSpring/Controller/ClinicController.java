package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Clinic;
import com.ISIS.KRMEFClinicSpring.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
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

}
