package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Consultation;
import com.ISIS.KRMEFClinicSpring.Repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class ConsultationService {
    @Autowired
    private ConsultationRepository consultationRepository;
    public List<Consultation> listAllConsultation() {
        return consultationRepository.findAll();
    }

    public void saveConsultation(Consultation consultation) {
        consultationRepository.save(consultation);
    }

    public Consultation getConsultation(Integer id) {
        return consultationRepository.findById(id).get();
    }

    public void deleteConsultation(Integer id) {
        consultationRepository.deleteById(id);
    }
}
