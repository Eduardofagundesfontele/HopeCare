package com.edutia.hopecare.donation.domain.model;

import com.edutia.hopecare.donation.domain.exception.DonationErroCode;
import com.edutia.hopecare.shared.exception.DomainException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = "id")
public class Donation {
    private Long id;
    private String donorName;
    private String donorEmail;
    private String donorPhone;
    private DonationType type;
    private BigDecimal amount;
    private String description;
    private DonationStatus status;
    private LocalDate donationDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Donation(){};

    //CREATE
    public static Donation create(
            String donorName,
            String donorEmail,
            String donorPhone,
            DonationType type,
            String description,
            DonationStatus status
    ){
        validate(
                donorName,
                donorEmail,
                type
        );

        Donation donation = new Donation();
        donation.donorName = donorName;
        donation.donorEmail = donorEmail;
        donation.donorPhone = donorPhone;
        donation.type = type;
        donation.description = description;
        donation.status = status;
        donation.donationDate = LocalDate.now();
        donation.createdAt = LocalDateTime.now();
        donation.updatedAt = LocalDateTime.now();

        return donation;
    }

    // RECONSTRUCT (FROM DATABASE)
    public static Donation reconstruct(
            Long id,
            String donorName,
            String donorEmail,
            String donorPhone,
            DonationType type,
            BigDecimal amount,
            String description,
             DonationStatus status,
            LocalDate donationDate,
            LocalDateTime createdAt,
            LocalDateTime updatedAt


    ){
        Donation donation = new Donation();

        donation.id = id;
        donation.donorName = donorName;
        donation.donorEmail = donorEmail;
        donation.donorPhone = donorPhone;
        donation.type = type;
        donation.amount = amount;
        donation.description = description;
        donation.status = status;
        donation.donationDate = donationDate;
        donation.createdAt = createdAt;
        donation.updatedAt = updatedAt;
    }

    //UPDATE
        public void update(
                String donorName,
                String donorEmail,
                String donorPhone,
                String description

        ){
            validate(
                    donorName,
                    donorEmail,
                    type
            );
            this.donorName = donorName;
            this.donorEmail = donorEmail;
            this.donorPhone = donorPhone;
            this.description = description;
    }

    // BUSINESS RULES
    private static void validate(
            String donorName,
            String donorEmail,
            DonationType donationType

    ){
        if(donorName == null || donorName.isBlank()){
            throw new DomainException(DonationErroCode.INVALID_NAME);
        }
        if(donorEmail == null || donorEmail.isBlank()){
            throw new DomainException(DonationErroCode.INVALID_EMAIL);
        }
        if (donationType == null){
            throw new DomainException(DonationErroCode.INVALID_TYPE);
        }
    }


}
