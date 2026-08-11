package com.edutia.hopecare.donation.presentation.mapper;

import com.edutia.hopecare.child.domain.model.Child;
import com.edutia.hopecare.child.presentation.dto.request.UpdateChildRequest;
import com.edutia.hopecare.child.presentation.dto.response.ChildResponse;
import com.edutia.hopecare.donation.domain.model.Donation;
import com.edutia.hopecare.donation.presentation.dto.request.CreateDonationRequest;
import com.edutia.hopecare.donation.presentation.dto.request.UpdateDonationRequest;
import com.edutia.hopecare.donation.presentation.dto.response.DonationResponse;

public interface DonationPresentationMapper {

    Donation toDomain (CreateDonationRequest request);

    Donation toDomainUpdate(UpdateDonationRequest request);

    DonationResponse toResponse(Donation donation);
}
