package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Resource;
import com.ISIS.KRMEFClinicSpring.Repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;
    public List<Resource> listAllResource() {
        return resourceRepository.findAll();
    }

    public void saveResource(Resource resource) {
        resourceRepository.save(resource);
    }

    public Resource getResource(Integer id) {
        return resourceRepository.findById(id).get();
    }

    public void deleteResource(Integer id) {
        resourceRepository.deleteById(id);
    }
}
