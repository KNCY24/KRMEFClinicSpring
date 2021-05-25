package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.DetailStock;
import com.ISIS.KRMEFClinicSpring.Repository.DetailStockRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class DetailStockService {
    @Autowired
    private DetailStockRepository detailStockRepository;
    public List<DetailStock> listAllDetailStock() {
        return detailStockRepository.findAll();
    }

    public void saveDetailStock(DetailStock detailStock) {
        detailStockRepository.save(detailStock);
    }

    public DetailStock getDetailStock(Integer id) {
        return detailStockRepository.findById(id).get();
    }

    public void deleteDetailStock(Integer id) {
        detailStockRepository.deleteById(id);
    }
}
