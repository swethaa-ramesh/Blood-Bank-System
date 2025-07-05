package com.example.bbms.controller;

import com.example.bbms.entity.Donor;
import com.example.bbms.service.DonorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donors")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class DonorController {
    private final DonorService donorService;

    @GetMapping
    public ResponseEntity<List<Donor>> getAllDonors() {
        return ResponseEntity.ok(donorService.getAllDonors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donor> getDonorById(@PathVariable Long id) {
        return ResponseEntity.ok(donorService.getDonorById(id));
    }

    @PostMapping
    public ResponseEntity<Donor> createDonor(@Valid @RequestBody Donor donor) {
        return ResponseEntity.ok(donorService.createDonor(donor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Donor> updateDonor(@PathVariable Long id, @Valid @RequestBody Donor donor) {
        return ResponseEntity.ok(donorService.updateDonor(id, donor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonor(@PathVariable Long id) {
        donorService.deleteDonor(id);
        return ResponseEntity.ok().build();
    }
} 