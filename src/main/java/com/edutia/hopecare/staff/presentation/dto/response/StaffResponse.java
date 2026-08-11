package com.edutia.hopecare.staff.presentation.dto.response;

import com.edutia.hopecare.staff.domain.model.StaffRole;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record StaffResponse(
        Long id,
        String name,
        String email,
        String phoneNumber,
        StaffRole staffRole,
        LocalDate hireDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
