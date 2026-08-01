package com.edutia.hopecare.staff.application.useCase;

import com.edutia.hopecare.staff.domain.model.Staff;
import com.edutia.hopecare.staff.domain.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteStaffUseCase {

    private final StaffRepository repository;

    public void execute(Long id){

        repository.deleteById(id);


    }
}
