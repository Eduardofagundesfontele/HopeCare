package com.edutia.hopecare.donation.application.usecase;

import com.edutia.hopecare.donation.domain.model.Donation;
import com.edutia.hopecare.donation.domain.repository.DonationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateDonationUseCase {

  private final  DonationRepository repository;

  public Donation execute(Donation donation){

    return repository.save(donation);
    }
}
