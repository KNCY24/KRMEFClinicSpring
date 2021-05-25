package com.ISIS.KRMEFClinicSpring.Service;

import com.ISIS.KRMEFClinicSpring.Model.History;
import com.ISIS.KRMEFClinicSpring.Repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;
    public List<History> listAllHistory() {
        return historyRepository.findAll();
    }

    public void saveHistory(History history) {
        historyRepository.save(history);
    }

    public History getHistory(Integer id) {
        return historyRepository.findById(id).get();
    }

    public void deleteHistory(Integer id) {
        historyRepository.deleteById(id);
    }
}
