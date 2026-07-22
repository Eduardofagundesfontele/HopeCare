package com.edutia.hopecare.child.application.usecase;

import com.edutia.hopecare.child.domain.exception.ChildErrorCode;
import com.edutia.hopecare.child.domain.model.Child;
import com.edutia.hopecare.child.domain.repository.ChildRepository;
import com.edutia.hopecare.shared.exception.DomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateChildUseCase {

    private final ChildRepository repository;

    public Child execute(Long id , Child updated) {
        Child child = repository.findById(id)
                .orElseThrow(() -> new DomainException(ChildErrorCode.CHILD_NOT_FOUND));

        child.update(
               updated.getFullName(),
                updated.getGender(),
                updated.getNationality(),
                updated.getMedicalNotes(),
                updated.getStatus()
        );

       return repository.save(child);
    }
}