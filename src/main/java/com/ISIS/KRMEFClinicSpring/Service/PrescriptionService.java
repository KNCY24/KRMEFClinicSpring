package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Prescription;
import com.ISIS.KRMEFClinicSpring.Repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;
    public List<Prescription> listAllPrescription() {
        return prescriptionRepository.findAll();
    }

    public void savePrescription(Prescription prescription) {
        prescriptionRepository.save(prescription);
    }

    public Prescription getPrescription(Integer id) {
        return prescriptionRepository.findById(id).get();
    }

    public void deletePrescription(Integer id) {
        prescriptionRepository.deleteById(id);
    }
}
