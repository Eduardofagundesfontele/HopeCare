package com.edutia.hopecare.donation.presentation.dto.request;

public record UpdateDonationRequest(
        String donorName,
        String donorEmail,
        String donorPhone,
        String description
) {
}
