package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Dependant;
import com.ISIS.KRMEFClinicSpring.Repository.DependantRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class DependantService {
    @Autowired
    private DependantRepository dependantRepository;
    public List<Dependant> listAllDependant() {
        return dependantRepository.findAll();
    }

    public void saveDependant(Dependant dependant) {
        dependantRepository.save(dependant);
    }

    public Dependant getDependant(Integer id) {
        return dependantRepository.findById(id).get();
    }

    public void deleteDependant(Integer id) {
        dependantRepository.deleteById(id);
    }
}
