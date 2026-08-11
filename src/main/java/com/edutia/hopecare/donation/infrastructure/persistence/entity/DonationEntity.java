package com.edutia.hopecare.donation.infrastructure.persistence.entity;

import com.edutia.hopecare.donation.domain.model.DonationStatus;
import com.edutia.hopecare.donation.domain.model.DonationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "donations")
@Getter
@Setter
public class DonationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "donor_name",nullable = false)
    private String donorName;

    @Column(name = "donor_email",nullable = false)
    private String donorEmail;

    @Column(name = "donor_phone",nullable = false)
    private String donorPhone;

    @Enumerated(EnumType.STRING)
    private DonationType type;

    private BigDecimal amount;

    private String description;

    @Enumerated(EnumType.STRING)
    private DonationStatus status;

    @Column(name = "donation_date")
    private LocalDate donationDate;

    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        updatedAt = LocalDateTime.now();
    }

}
