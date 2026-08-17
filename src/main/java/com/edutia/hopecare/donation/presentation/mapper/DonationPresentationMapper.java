package com.edutia.hopecare.donation.presentation.mapper;

import com.edutia.hopecare.child.domain.model.Child;
import com.edutia.hopecare.child.presentation.dto.request.UpdateChildRequest;
import com.edutia.hopecare.child.presentation.dto.response.ChildResponse;
import com.edutia.hopecare.donation.application.command.UpdateDonationCommand;
import com.edutia.hopecare.donation.domain.model.Donation;
import com.edutia.hopecare.donation.presentation.dto.request.CreateDonationRequest;
import com.edutia.hopecare.donation.presentation.dto.request.UpdateDonationRequest;
import com.edutia.hopecare.donation.presentation.dto.response.DonationResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DonationPresentationMapper {

    default Donation toDomain(CreateDonationRequest request) {

        if (request == null) {
            return null;
        }

        return Donation.create(
                request.donorName(),
                request.donorEmail(),
                request.donorPhone(),
                request.type(),
                request.description(),
                request.status()
        );
    }
    default UpdateDonationCommand toCommand(UpdateDonationRequest request) {

        if (request == null) {
            return null;
        }

        return new UpdateDonationCommand(
                request.donorName(),
                request.donorEmail(),
                request.donorPhone(),
                request.description()
        );
    }

    DonationResponse toResponse(Donation donation);
}
