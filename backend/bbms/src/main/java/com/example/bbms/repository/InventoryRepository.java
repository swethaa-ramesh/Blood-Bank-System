package com.example.bbms.repository;

import com.example.bbms.entity.Inventory;
import com.example.bbms.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @Lock(LockModeType.OPTIMISTIC)
    Optional<Inventory> findByBloodType(Request.BloodGroup bloodType);

    @Query("SELECT i FROM Inventory i WHERE i.bloodType = :bloodType AND i.quantity >= :quantity")
    Optional<Inventory> findByBloodTypeAndQuantityGreaterThanEqual(Request.BloodGroup bloodType, Integer quantity);

    List<Inventory> findByStatus(String status);
} 