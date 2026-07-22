package com.edutia.hopecare.child.application.usecase;

import com.edutia.hopecare.child.domain.exception.ChildErrorCode;
import com.edutia.hopecare.child.domain.repository.ChildRepository;
import com.edutia.hopecare.shared.exception.DomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteChildUseCase {

    private final ChildRepository repository;

    public void execute(Long id){

        repository.findById(id)
                .orElseThrow(()-> new DomainException(ChildErrorCode.CHILD_NOT_FOUND));

        repository.deleteById(id);
    }
}
