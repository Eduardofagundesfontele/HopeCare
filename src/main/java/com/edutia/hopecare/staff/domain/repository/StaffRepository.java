package com.edutia.hopecare.staff.domain.repository;

import com.edutia.hopecare.donation.domain.model.Donation;
import com.edutia.hopecare.staff.domain.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface StaffRepository {

    Staff save(Staff staff);

    Optional<Staff> findById(Long id);

    Page<Staff> findAll(Pageable pageable);

    void deleteById(Long id);
}
