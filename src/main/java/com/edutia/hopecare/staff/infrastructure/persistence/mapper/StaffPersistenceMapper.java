package com.edutia.hopecare.staff.infrastructure.persistence.mapper;

import com.edutia.hopecare.child.infrastructure.persistence.entity.ChildEntity;
import com.edutia.hopecare.staff.domain.model.Staff;
import com.edutia.hopecare.staff.infrastructure.persistence.entity.StaffEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StaffPersistenceMapper {

    StaffEntity toEntity(Staff staff);

    Staff toDomain(StaffEntity entity);
}
