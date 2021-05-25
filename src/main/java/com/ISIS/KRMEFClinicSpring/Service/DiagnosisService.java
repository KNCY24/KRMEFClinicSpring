package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Diagnosis;
import com.ISIS.KRMEFClinicSpring.Repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class DiagnosisService {
    @Autowired
    private DiagnosisRepository diagnosisRepository;
    public List<Diagnosis> listAllDiagnosis() {
        return diagnosisRepository.findAll();
    }

    public void saveDiagnosis(Diagnosis diagnosis) {
        diagnosisRepository.save(diagnosis);
    }

    public Diagnosis getDiagnosis(Integer id) {
        return diagnosisRepository.findById(id).get();
    }

    public void deleteDiagnosis(Integer id) {
        diagnosisRepository.deleteById(id);
    }
}
