package com.example.bbms.repository;

import com.example.bbms.entity.Donor;
import com.example.bbms.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
    List<Donor> findByBloodGroup(Request.BloodGroup bloodGroup);
    List<Donor> findByUserId(Long userId);
} 