package com.edutia.hopecare.child.application.usecase;

import com.edutia.hopecare.child.domain.model.Child;
import com.edutia.hopecare.child.domain.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateChildUseCase {

    private final ChildRepository repository;

    public Child execute(Child child){

        return repository.save(child);
    }
}
