package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Allergy;
import com.ISIS.KRMEFClinicSpring.Model.User;
import com.ISIS.KRMEFClinicSpring.Repository.AllergyRepository;
import com.ISIS.KRMEFClinicSpring.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class AllergyService {
    @Autowired
    private AllergyRepository allergyRepository;
    public List<Allergy> listAllAllergy() {
        return allergyRepository.findAll();
    }

    public void saveAllergy(Allergy allergy) {
        allergyRepository.save(allergy);
    }

    public Allergy getAllergy(Integer id) {
        return allergyRepository.findById(id).get();
    }

    public void deleteAllergy(Integer id) {
        allergyRepository.deleteById(id);
    }
}
