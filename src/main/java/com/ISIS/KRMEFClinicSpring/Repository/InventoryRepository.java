package com.ISIS.KRMEFClinicSpring.Repository;

import com.ISIS.KRMEFClinicSpring.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
}
