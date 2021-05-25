package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Benefit;
import com.ISIS.KRMEFClinicSpring.Repository.BenefitRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class BenefitService {
    @Autowired
    private BenefitRepository benefitRepository;
    public List<Benefit> listAllBenefit() {
        return benefitRepository.findAll();
    }

    public void saveBenefit(Benefit benefit) {
        benefitRepository.save(benefit);
    }

    public Benefit getBenefit(Integer id) {
        return benefitRepository.findById(id).get();
    }

    public void deleteBenefit(Integer id) {
        benefitRepository.deleteById(id);
    }
}
