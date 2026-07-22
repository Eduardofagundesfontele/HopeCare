package com.edutia.hopecare.donation.application.usecase;

import com.edutia.hopecare.donation.domain.model.Donation;
import com.edutia.hopecare.donation.domain.repository.DonationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class FindAllDonationUseCase {

   private final DonationRepository repository;

    public Page<Donation> execute(Pageable pageable){

        return repository.findAll(pageable);
    }
}
