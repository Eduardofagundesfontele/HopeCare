package com.edutia.hopecare.donation.application.usecase;

import com.edutia.hopecare.donation.domain.exception.DonationErroCode;
import com.edutia.hopecare.donation.domain.repository.DonationRepository;
import com.edutia.hopecare.shared.exception.DomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteDonationUserCase {

    private final DonationRepository repository;

    public void execute(Long id){

        repository.findById(id)
                .orElseThrow(()->new DomainException(DonationErroCode.DONATION_NOT_FOUND));

        repository.deleteById(id);
    }
}
