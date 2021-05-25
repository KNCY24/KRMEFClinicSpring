package com.ISIS.KRMEFClinicSpring.Repository;

import com.ISIS.KRMEFClinicSpring.Model.Diagnosis;
import com.ISIS.KRMEFClinicSpring.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis,Integer> {
}
