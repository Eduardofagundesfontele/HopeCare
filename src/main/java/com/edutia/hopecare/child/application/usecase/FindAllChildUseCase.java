package com.edutia.hopecare.child.application.usecase;

import com.edutia.hopecare.child.domain.model.Child;
import com.edutia.hopecare.child.domain.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllChildUseCase {

    private final ChildRepository repository;

    public Page<Child> execute(Pageable pageable){

        return repository.findAll(pageable);
    }
}
