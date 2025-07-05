package com.example.bbms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "donors")
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @Past
    private LocalDate dateOfBirth;

    @NotBlank
    private String contactNumber;

    @NotBlank
    private String address;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Request.BloodGroup bloodGroup;

    @NotNull
    private LocalDate lastDonationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
} 