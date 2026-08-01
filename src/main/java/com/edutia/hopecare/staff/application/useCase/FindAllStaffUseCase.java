package com.edutia.hopecare.staff.application.useCase;

import com.edutia.hopecare.staff.domain.model.Staff;
import com.edutia.hopecare.staff.domain.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllStaffUseCase {

    private final StaffRepository repository;

    public Page<Staff> execute(Pageable pageable){

        return repository.findAll(pageable);
    }
}
