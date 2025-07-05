package com.example.bbms.repository;

import com.example.bbms.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByRequesterId(Long requesterId);
    List<Request> findByStatus(Request.Status status);
    List<Request> findByBloodGroup(Request.BloodGroup bloodGroup);
} 