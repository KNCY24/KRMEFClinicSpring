package com.ISIS.KRMEFClinicSpring.Repository;

import com.ISIS.KRMEFClinicSpring.Model.History;
import com.ISIS.KRMEFClinicSpring.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History,Integer> {
}
