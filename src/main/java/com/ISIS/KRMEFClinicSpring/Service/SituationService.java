package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Situation;
import com.ISIS.KRMEFClinicSpring.Repository.SituationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class SituationService {
    @Autowired
    private SituationRepository situationRepository;
    public List<Situation> listAllSituation() {
        return situationRepository.findAll();
    }

    public void saveSituation(Situation situation) {
        situationRepository.save(situation);
    }

    public Situation getSituation(Integer id) {
        return situationRepository.findById(id).get();
    }

    public void deleteSituation(Integer id) {
        situationRepository.deleteById(id);
    }
}
