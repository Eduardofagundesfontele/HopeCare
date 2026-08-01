package com.edutia.hopecare.staff.application.useCase;

import com.edutia.hopecare.shared.exception.DomainException;
import com.edutia.hopecare.staff.domain.exception.StaffErrorCode;
import com.edutia.hopecare.staff.domain.model.Staff;
import com.edutia.hopecare.staff.domain.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindStaffByIdUseCase {

    private final StaffRepository repository;

    public Staff execute(Long id){

        return repository.findById(id)
                .orElseThrow(()->new DomainException(StaffErrorCode.STAFF_NOT_FOUND));
    }
}
