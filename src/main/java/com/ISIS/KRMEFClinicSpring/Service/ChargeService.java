package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Charge;
import com.ISIS.KRMEFClinicSpring.Repository.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class ChargeService {
    @Autowired
    private ChargeRepository chargeRepository;
    public List<Charge> listAllCharge() {
        return chargeRepository.findAll();
    }

    public void saveCharge(Charge charge) {
        chargeRepository.save(charge);
    }

    public Charge getCharge(Integer id) {
        return chargeRepository.findById(id).get();
    }

    public void deleteCharge(Integer id) {
        chargeRepository.deleteById(id);
    }
}
