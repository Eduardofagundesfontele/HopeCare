package com.edutia.hopecare.donation.domain.repository;

import com.edutia.hopecare.child.domain.model.Child;
import com.edutia.hopecare.donation.domain.model.Donation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface DonationRepository {

    Donation save(Donation donation);

    Optional<Donation> findById(Long id);

    Page<Donation> findAll (Pageable pageable);

    void deleteById(Long id);



}
