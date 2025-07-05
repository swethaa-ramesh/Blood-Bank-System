package com.example.bbms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String patientName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @NotNull
    @Positive
    private Integer unitsRequired;

    @NotBlank
    private String hospital;

    @NotNull
    private LocalDateTime requestDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User requester;

    public enum Status {
        PENDING,
        APPROVED,
        REJECTED,
        FULFILLED
    }

    public enum BloodGroup {
        A_POSITIVE("A+"),
        A_NEGATIVE("A-"),
        B_POSITIVE("B+"),
        B_NEGATIVE("B-"),
        AB_POSITIVE("AB+"),
        AB_NEGATIVE("AB-"),
        O_POSITIVE("O+"),
        O_NEGATIVE("O-");

        private final String displayName;

        BloodGroup(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }

        public static BloodGroup fromDisplayName(String displayName) {
            for (BloodGroup group : values()) {
                if (group.displayName.equals(displayName)) {
                    return group;
                }
            }
            throw new IllegalArgumentException("Unknown blood group: " + displayName);
        }
    }
} 