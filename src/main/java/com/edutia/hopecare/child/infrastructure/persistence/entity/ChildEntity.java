package com.edutia.hopecare.child.infrastructure.persistence.entity;

import com.edutia.hopecare.child.domain.model.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "children")
@Getter
@Setter
public class ChildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name",nullable = false,length = 200)
    private String fullName;

    @Column(name = "birth_date",nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private Gender gender;

    @Column(nullable = false,length = 100)
    private String nationality;

    @Column(name = "medical_notes",columnDefinition = "TEXT")
    private String medicalNotes;

    @Column(nullable = false,length = 100)
    private String status;

    @Column(name = "admission_date",nullable = false)
    private LocalDate admissionDate;

    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted",nullable = false)
    private Boolean deleted = false;




}
