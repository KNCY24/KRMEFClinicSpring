package com.ISIS.KRMEFClinicSpring.Repository;

import com.ISIS.KRMEFClinicSpring.Model.Patient;
import com.ISIS.KRMEFClinicSpring.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
