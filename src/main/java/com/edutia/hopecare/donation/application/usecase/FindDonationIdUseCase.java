package com.edutia.hopecare.donation.application.usecase;


import com.edutia.hopecare.donation.domain.exception.DonationErrorCode;
import com.edutia.hopecare.donation.domain.model.Donation;
import com.edutia.hopecare.donation.domain.repository.DonationRepository;
import com.edutia.hopecare.shared.exception.DomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindDonationIdUseCase {

    private final DonationRepository repository;

    public Donation execute(Long id){
      return repository.findById(id)
                .orElseThrow(()->new DomainException(DonationErrorCode.DONATION_NOT_FOUND));
    }
}
