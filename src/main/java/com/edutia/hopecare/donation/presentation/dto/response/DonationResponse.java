package com.edutia.hopecare.donation.presentation.dto.response;

import com.edutia.hopecare.donation.domain.model.DonationStatus;
import com.edutia.hopecare.donation.domain.model.DonationType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record DonationResponse(
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
) {
}
