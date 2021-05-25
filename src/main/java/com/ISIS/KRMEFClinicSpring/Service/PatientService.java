package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Patient;
import com.ISIS.KRMEFClinicSpring.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    public List<Patient> listAllPatient() {
        return patientRepository.findAll();
    }

    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    public Patient getPatient(Integer id) {
        return patientRepository.findById(id).get();
    }

    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }
}
