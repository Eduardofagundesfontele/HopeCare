package com.edutia.hopecare.donation.infrastructure.persistence.mapper;

import com.edutia.hopecare.child.domain.model.Child;
import com.edutia.hopecare.child.infrastructure.persistence.entity.ChildEntity;
import com.edutia.hopecare.donation.domain.model.Donation;
import com.edutia.hopecare.donation.infrastructure.persistence.entity.DonationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DonationPersistenceMapper {

    DonationEntity toEntity(Donation donation);

    Donation toDonation(DonationEntity DonationEntity);
}
