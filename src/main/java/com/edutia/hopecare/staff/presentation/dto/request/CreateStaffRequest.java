package com.edutia.hopecare.staff.presentation.dto.request;

import com.edutia.hopecare.staff.domain.model.StaffRole;

import java.time.LocalDate;

public record CreateStaffRequest(
        String name,
        String email,
        String phoneNumber,
        StaffRole staffRole,
        LocalDate hireDate
) {
}
