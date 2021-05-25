package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.Medicine;
import com.ISIS.KRMEFClinicSpring.Repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;
    public List<Medicine> listAllMedicine() {
        return medicineRepository.findAll();
    }

    public void saveMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    public Medicine getMedicine(Integer id) {
        return medicineRepository.findById(id).get();
    }

    public void deleteMedicine(Integer id) {
        medicineRepository.deleteById(id);
    }
}
