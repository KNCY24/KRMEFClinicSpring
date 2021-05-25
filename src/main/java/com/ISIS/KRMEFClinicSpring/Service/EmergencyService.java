package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Emergency;
import com.ISIS.KRMEFClinicSpring.Repository.EmergencyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class EmergencyService {
    @Autowired
    private EmergencyRepository emergencyRepository;
    public List<Emergency> listAllEmergency() {
        return emergencyRepository.findAll();
    }

    public void saveEmergency(Emergency emergency) {
        emergencyRepository.save(emergency);
    }

    public Emergency getEmergency(Integer id) {
        return emergencyRepository.findById(id).get();
    }

    public void deleteEmergency(Integer id) {
        emergencyRepository.deleteById(id);
    }
}
