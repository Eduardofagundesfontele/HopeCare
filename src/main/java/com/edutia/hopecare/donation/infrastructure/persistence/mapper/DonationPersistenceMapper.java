package com.edutia.hopecare.donation.infrastructure.persistence.mapper;

import com.edutia.hopecare.child.domain.model.Child;
import com.edutia.hopecare.child.infrastructure.persistence.entity.ChildEntity;
import com.edutia.hopecare.donation.domain.model.Donation;
import com.edutia.hopecare.donation.infrastructure.persistence.entity.DonationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DonationPersistenceMapper {

    DonationEntity toEntity(Donation donation);

   default Donation toDonation(DonationEntity entity){
       if (entity == null) {
           return null;
       }
       return Donation.reconstruct(
               entity.getId(),
               entity.getDonorName(),
               entity.getDonorEmail(),
               entity.getDonorPhone(),
               entity.getType(),
               entity.getAmount(),
               entity.getDescription(),
               entity.getStatus(),
               entity.getDonationDate(),
               entity.getCreatedAt(),
               entity.getUpdatedAt()
       );
   }
}
