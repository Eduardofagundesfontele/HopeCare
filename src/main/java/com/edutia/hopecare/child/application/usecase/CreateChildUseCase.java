package com.edutia.hopecare.child.application.usecase;

import com.edutia.hopecare.child.domain.model.Child;
import com.edutia.hopecare.child.domain.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CreateChildUseCase {

    private final ChildRepository repository;

    public Child execute(
            String fullName,
            LocalDate birthDate,
            String gender,
            String nationality,
            String medicalNotes,
            String status
    ){

        Child child = Child.create(
                fullName,
                birthDate,
                gender,
                nationality,
                medicalNotes,
                status
        );
        return repository.save(child);
    }
}
