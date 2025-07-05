package com.example.bbms.service;

import com.example.bbms.entity.Request;
import com.example.bbms.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Request getRequestById(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found with id: " + id));
    }

    @Transactional
    public Request createRequest(Request request) {
        return requestRepository.save(request);
    }

    @Transactional
    public Request updateRequest(Long id, Request request) {
        Request existingRequest = getRequestById(id);
        
        existingRequest.setPatientName(request.getPatientName());
        existingRequest.setBloodGroup(request.getBloodGroup());
        existingRequest.setUnitsRequired(request.getUnitsRequired());
        existingRequest.setHospital(request.getHospital());
        existingRequest.setStatus(request.getStatus());
        existingRequest.setRequester(request.getRequester());
        
        return requestRepository.save(existingRequest);
    }

    @Transactional
    public void deleteRequest(Long id) {
        if (!requestRepository.existsById(id)) {
            throw new RuntimeException("Request not found with id: " + id);
        }
        requestRepository.deleteById(id);
    }

    public List<Request> getRequestsByStatus(Request.Status status) {
        return requestRepository.findByStatus(status);
    }
} 