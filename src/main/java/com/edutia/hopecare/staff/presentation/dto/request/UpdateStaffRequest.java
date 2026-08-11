package com.edutia.hopecare.staff.presentation.dto.request;

import com.edutia.hopecare.staff.domain.model.StaffRole;

public record UpdateStaffRequest(
        String name,
        String email,
        String phoneNumber,
        StaffRole staffRole
) {
}
