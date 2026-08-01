package com.edutia.hopecare.staff.application.useCase;

import com.edutia.hopecare.staff.domain.model.Staff;
import com.edutia.hopecare.staff.domain.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStaffUseCase {

    private final StaffRepository repository;

    public Staff execute(Staff staff){

        return repository.save(staff);
    }
}
