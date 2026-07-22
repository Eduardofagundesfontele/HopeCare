package com.edutia.hopecare.child.presentation.dto.request;

import com.edutia.hopecare.child.domain.model.Gender;

import java.time.LocalDate;

public record CreateChildRequest(
        String fullName,
        LocalDate birthDate,
        Gender gender,
        String nationality,
        String medicalNotes,
        String status,
        LocalDate admissionDate
) {
}
