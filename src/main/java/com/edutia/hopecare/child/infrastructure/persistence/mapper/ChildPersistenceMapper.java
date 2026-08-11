package com.edutia.hopecare.child.infrastructure.persistence.mapper;

import com.edutia.hopecare.child.domain.model.Child;
import com.edutia.hopecare.child.infrastructure.persistence.entity.ChildEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChildPersistenceMapper  {

    ChildEntity toEntity(Child child);

   default Child toDomain (ChildEntity entity){

       if (entity == null) {
           return null;
       }
       return Child.reconstruct(
               entity.getId(),
               entity.getFullName(),
               entity.getBirthDate(),
               entity.getGender(),
               entity.getNationality(),
               entity.getMedicalNotes(),
               entity.getStatus(),
               entity.getAdmissionDate(),
               entity.getCreatedAt(),
               entity.getUpdatedAt()
       );
   }
}
