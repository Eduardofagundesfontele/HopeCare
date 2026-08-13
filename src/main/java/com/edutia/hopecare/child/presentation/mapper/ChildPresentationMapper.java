package com.edutia.hopecare.child.presentation.mapper;

import com.edutia.hopecare.child.domain.model.Child;
import com.edutia.hopecare.child.presentation.dto.request.CreateChildRequest;
import com.edutia.hopecare.child.presentation.dto.request.UpdateChildRequest;
import com.edutia.hopecare.child.presentation.dto.response.ChildResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChildPresentationMapper {
    default Child toDomain(CreateChildRequest request) {
        if (request == null) {
            return null;
        } return Child.create(
                request.fullName(),
                request.birthDate(),
                request.gender(),
                request.nationality(),
                request.medicalNotes(),
                request.status()
        );
    }

    default Child toDomainUpdate(UpdateChildRequest request) {
        if (request == null) {
            return null;
        }

        return Child.create(
                request.fullName(),
                request.birthDate(),
                request.gender(),
                request.nationality(),
                request.medicalNotes(),
                request.status()
        );
    }

    ChildResponse toResponse(Child child);
}
