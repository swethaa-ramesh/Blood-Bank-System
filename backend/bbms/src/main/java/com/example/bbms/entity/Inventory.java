package com.example.bbms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = BloodGroupDeserializer.class)
    private Request.BloodGroup bloodType;

    @NotNull
    @PositiveOrZero
    private Integer quantity;

    @NotNull
    private String location;

    @NotNull
    private LocalDate expirationDate;

    private String status = "Available";

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private Donor donor;

    @Version
    private Long version;
} 