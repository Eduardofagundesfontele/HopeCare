package com.edutia.hopecare.child.presentation.dto.response;

import com.edutia.hopecare.child.domain.model.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ChildResponse(
        Long id,
        String fullName,
        LocalDate birthDate,
        Gender gender,
        String nationality,
        String medicalNotes,
        String status,
        LocalDate admissionDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
