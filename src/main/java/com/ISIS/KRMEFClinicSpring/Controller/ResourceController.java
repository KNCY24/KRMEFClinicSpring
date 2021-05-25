package com.ISIS.KRMEFClinicSpring.Controller;

import com.ISIS.KRMEFClinicSpring.Model.Resource;
import com.ISIS.KRMEFClinicSpring.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    @Autowired
    ResourceService resourceService;

    @GetMapping("")
    public List<Resource> list() {
        return resourceService.listAllResource();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> get(@PathVariable Integer id) {
        try {
            Resource resource = resourceService.getResource(id);
            return new ResponseEntity<Resource>(resource, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Resource resource) {
        resourceService.saveResource(resource);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Resource resource, @PathVariable Integer id) {
        try {
            Resource existResource = resourceService.getResource(id);
            resource.setIdresource(id);
            resourceService.saveResource(resource);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        resourceService.deleteResource(id);
    }
}
