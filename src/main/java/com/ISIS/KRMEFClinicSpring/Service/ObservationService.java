package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Observation;
import com.ISIS.KRMEFClinicSpring.Repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class ObservationService {
    @Autowired
    private ObservationRepository observationRepository;
    public List<Observation> listAllObservation() {
        return observationRepository.findAll();
    }

    public void saveObservation(Observation observation) {
        observationRepository.save(observation);
    }

    public Observation getObservation(Integer id) {
        return observationRepository.findById(id).get();
    }

    public void deleteObservation(Integer id) {
        observationRepository.deleteById(id);
    }
}
