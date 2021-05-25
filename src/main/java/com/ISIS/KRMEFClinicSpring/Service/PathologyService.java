package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Pathology;
import com.ISIS.KRMEFClinicSpring.Repository.PathologyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class PathologyService {
    @Autowired
    private PathologyRepository pathologyRepository;
    public List<Pathology> listAllPathology() {
        return pathologyRepository.findAll();
    }

    public void savePathology(Pathology pathology) {
        pathologyRepository.save(pathology);
    }

    public Pathology getPathology(Integer id) {
        return pathologyRepository.findById(id).get();
    }

    public void deletePathology(Integer id) {
        pathologyRepository.deleteById(id);
    }
}
