package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Treatment;
import com.ISIS.KRMEFClinicSpring.Repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class TreatmentService {
    @Autowired
    private TreatmentRepository treatmentRepository;
    public List<Treatment> listAllTreatment() {
        return treatmentRepository.findAll();
    }

    public void saveTreatment(Treatment treatment) {
        treatmentRepository.save(treatment);
    }

    public Treatment getTreatment(Integer id) {
        return treatmentRepository.findById(id).get();
    }

    public void deleteTreatment(Integer id) {
        treatmentRepository.deleteById(id);
    }
}
