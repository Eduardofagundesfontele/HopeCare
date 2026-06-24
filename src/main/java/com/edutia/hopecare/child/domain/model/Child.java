package com.edutia.hopecare.child.domain.model;

import com.edutia.hopecare.child.domain.exception.ChildErrorCode;
import com.edutia.hopecare.shared.exception.DomainException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = "id")
public class Child {
    private long id;
    private String fullName;
    private LocalDate birthDate;
    private String gender;
    private String nationality;

    private String medicalNotes;

    private String status;
    private LocalDate admissionDate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Child(){}

    // CREATE (NEW CHILD)
    public static Child create(
            String fullName,
            LocalDate birthDate,
            String gender,
            String nationality,
            String medicalNotes,
            String status

    ){
        validate(
                fullName,
                birthDate,
                gender,
                nationality
        );

        Child child = new Child();

        child.fullName=fullName;
        child.birthDate=birthDate;
        child.gender=gender;
        child.nationality=nationality;
        child.medicalNotes=medicalNotes;
        child.status=status;

        child.admissionDate=LocalDate.now();

        child.createdAt=LocalDateTime.now();
        child.updatedAt=LocalDateTime.now();

        return child;
    }

    // RECONSTRUCT (FROM DATABASE)
    public static Child reconstruct(
            Long id,
            String fullName,
            LocalDate birthDate,
            String gender,
            String nationality,
            String medicalNotes,
            String status,
            LocalDate admissionDate,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ){
        Child child = new Child();

        child.id=id;
        child.fullName=fullName;
        child.birthDate=birthDate;
        child.gender=gender;
        child.nationality=nationality;
        child.medicalNotes=medicalNotes;
        child.status=status;
        child.admissionDate=admissionDate;
        child.createdAt=createdAt;
        child.updatedAt=updatedAt;

        return child;

    }

    // UPDATE
    public void  update(
            String fullName,
            String gender,
            String nationality,
            String medicalNotes,
            String status
    ){
        validate(
                fullName,
                this.birthDate,
                gender,
                nationality
        );

        this.fullName=fullName;
        this.gender=gender;
        this.nationality=nationality;
        this.medicalNotes=medicalNotes;
        this.status=status;

        this.updatedAt=LocalDateTime.now();
    }

    // BUSINESS RULES
    private static void validate(
            String fullName,
            LocalDate birthDate,
            String gender,
            String nationality
    ){
        if (fullName == null || fullName.isBlank()) {
            throw new DomainException(ChildErrorCode.INVALID_NAME);
        }

        if (birthDate == null) {
            throw new DomainException(ChildErrorCode.INVALID_BIRTH_DATE);
        }

        if (gender == null || gender.isBlank()) {
            throw new DomainException(ChildErrorCode.INVALID_GENDER);
        }

        if (nationality == null || nationality.isBlank()) {
            throw new DomainException(ChildErrorCode.INVALID_NATIONALITY);
        }
    }



}
