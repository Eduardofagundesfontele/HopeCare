package com.edutia.hopecare.donation.infrastructure.persistence.repository;

import com.edutia.hopecare.donation.infrastructure.persistence.entity.DonationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationJpaRepository extends JpaRepository<DonationEntity,Long> {
}
