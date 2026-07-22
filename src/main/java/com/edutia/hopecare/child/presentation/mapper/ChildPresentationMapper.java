package com.edutia.hopecare.child.presentation.mapper;

import com.edutia.hopecare.child.domain.model.Child;
import com.edutia.hopecare.child.presentation.dto.request.CreateChildRequest;
import com.edutia.hopecare.child.presentation.dto.request.UpdateChildRequest;
import com.edutia.hopecare.child.presentation.dto.response.ChildResponse;

public interface ChildPresentationMapper {

    Child toDomain (CreateChildRequest request);

    Child toDomainUpdate(UpdateChildRequest request);

    ChildResponse toResponse(Child child);
}
