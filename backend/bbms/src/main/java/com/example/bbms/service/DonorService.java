package com.example.bbms.service;

import com.example.bbms.entity.Donor;
import com.example.bbms.repository.DonorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonorService {
    private final DonorRepository donorRepository;

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Donor getDonorById(Long id) {
        return donorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donor not found with id: " + id));
    }

    @Transactional
    public Donor createDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    @Transactional
    public Donor updateDonor(Long id, Donor donor) {
        Donor existingDonor = getDonorById(id);
        
        existingDonor.setName(donor.getName());
        existingDonor.setDateOfBirth(donor.getDateOfBirth());
        existingDonor.setContactNumber(donor.getContactNumber());
        existingDonor.setAddress(donor.getAddress());
        existingDonor.setBloodGroup(donor.getBloodGroup());
        existingDonor.setLastDonationDate(donor.getLastDonationDate());
        
        return donorRepository.save(existingDonor);
    }

    @Transactional
    public void deleteDonor(Long id) {
        if (!donorRepository.existsById(id)) {
            throw new RuntimeException("Donor not found with id: " + id);
        }
        donorRepository.deleteById(id);
    }
} 