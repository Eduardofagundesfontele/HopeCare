package com.edutia.hopecare.donation.infrastructure.persistence.repository;

import com.edutia.hopecare.donation.domain.model.Donation;
import com.edutia.hopecare.donation.domain.repository.DonationRepository;
import com.edutia.hopecare.donation.infrastructure.persistence.entity.DonationEntity;
import com.edutia.hopecare.donation.infrastructure.persistence.mapper.DonationPersistenceMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class DonationRepositoryImpl  implements DonationRepository{

    private final DonationJpaRepository repository;
    private final DonationPersistenceMapper mapper;

    @Override
    public Donation save(Donation donation) {
        DonationEntity donationEntity = mapper.toEntity(donation);

        DonationEntity savedDonation  = repository.save(donationEntity);

        return mapper.toDonation(savedDonation);
    }

    @Override
    public Optional<Donation> findById(Long id) {

        return repository.findById(id)
                .map(mapper::toDonation);
    }

    @Override
    public Page<Donation> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDonation);
    }

    @Override
    public void deleteById(Long id) {

        repository.deleteById(id);

    }
}
