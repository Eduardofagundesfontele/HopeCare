package com.edutia.hopecare.child.application.usecase;

import com.edutia.hopecare.child.domain.model.Child;
import com.edutia.hopecare.child.domain.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindChildByIdUseCase {

    private final ChildRepository repository;

    public Child execute(Long id){

        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Child not found"));

    }
}
