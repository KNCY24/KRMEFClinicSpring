package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Family;
import com.ISIS.KRMEFClinicSpring.Repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class FamilyService {
    @Autowired
    private FamilyRepository familyRepository;
    public List<Family> listAllFamily() {
        return familyRepository.findAll();
    }

    public void saveFamily(Family family) {
        familyRepository.save(family);
    }

    public Family getFamily(Integer id) {
        return familyRepository.findById(id).get();
    }

    public void deleteFamily(Integer id) {
        familyRepository.deleteById(id);
    }
}
