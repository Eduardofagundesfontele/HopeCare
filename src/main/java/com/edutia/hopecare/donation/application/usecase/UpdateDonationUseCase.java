package com.edutia.hopecare.donation.application.usecase;

import com.edutia.hopecare.donation.domain.exception.DonationErroCode;
import com.edutia.hopecare.donation.domain.model.Donation;
import com.edutia.hopecare.donation.domain.repository.DonationRepository;
import com.edutia.hopecare.shared.exception.DomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateDonationUseCase {

    private final DonationRepository repository;

    public Donation execute(Long id,Donation updated){
        Donation donation = repository.findById(id)
                .orElseThrow(()->new DomainException(DonationErroCode.DONATION_NOT_FOUND));

        donation.update(
                updated.getDonorName(),
                updated.getDonorEmail(),
                updated.getDonorPhone(),
                updated.getDescription()
        );

        return repository.save(donation);

    }
}
