package com.ISIS.KRMEFClinicSpring.Repository;

import com.ISIS.KRMEFClinicSpring.Model.Emergency;
import com.ISIS.KRMEFClinicSpring.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyRepository extends JpaRepository<Emergency,Integer> {
}
