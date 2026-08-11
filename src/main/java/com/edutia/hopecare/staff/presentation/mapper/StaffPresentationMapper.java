package com.edutia.hopecare.staff.presentation.mapper;

import com.edutia.hopecare.staff.domain.model.Staff;
import com.edutia.hopecare.staff.presentation.dto.request.CreateStaffRequest;
import com.edutia.hopecare.staff.presentation.dto.request.UpdateStaffRequest;
import com.edutia.hopecare.staff.presentation.dto.response.StaffResponse;

public interface StaffPresentationMapper {

    Staff toDomain(CreateStaffRequest request);

    Staff toDomainUpdate(UpdateStaffRequest request);

    StaffResponse toResponse(Staff staff);
}
