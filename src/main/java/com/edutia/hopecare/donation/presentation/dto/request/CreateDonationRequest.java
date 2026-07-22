package com.edutia.hopecare.donation.presentation.dto.request;

import com.edutia.hopecare.donation.domain.model.DonationStatus;
import com.edutia.hopecare.donation.domain.model.DonationType;

public record CreateDonationRequest(String donorName,
                                    String donorEmail,
                                    String donorPhone,
                                    DonationType type,
                                    String description,
                                    DonationStatus status) {
}
