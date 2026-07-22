package com.edutia.hopecare.child.infrastructure.persistence.mapper;

import com.edutia.hopecare.child.domain.model.Child;
import com.edutia.hopecare.child.infrastructure.persistence.entity.ChildEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChildPersistenceMapper  {

    ChildEntity toEntity(Child child);

    Child toDomain(ChildEntity entity);
}
