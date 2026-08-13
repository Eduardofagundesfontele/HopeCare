package com.edutia.hopecare.staff.presentation.mapper;

import com.edutia.hopecare.staff.domain.model.Staff;
import com.edutia.hopecare.staff.presentation.dto.request.CreateStaffRequest;
import com.edutia.hopecare.staff.presentation.dto.request.UpdateStaffRequest;
import com.edutia.hopecare.staff.presentation.dto.response.StaffResponse;

public interface StaffPresentationMapper {

    default Staff toDomain(CreateStaffRequest request) {

        if (request == null) {
            return null;
        }

        return Staff.create(
                request.name(),
                request.email(),
                request.phoneNumber(),
                request.staffRole(),
                request.hireDate()
        );
    }
    default void updateDomain(
            Staff staff,
            UpdateStaffRequest request
    ) {

        if (request == null) {
            return;
        }

        staff.update(
                request.name(),
                request.email(),
                request.phoneNumber(),
                request.staffRole()
        );
    }


    StaffResponse toResponse(Staff staff);
}
