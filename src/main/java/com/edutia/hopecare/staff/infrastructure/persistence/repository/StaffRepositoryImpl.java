package com.edutia.hopecare.staff.infrastructure.persistence.repository;

import com.edutia.hopecare.staff.domain.model.Staff;
import com.edutia.hopecare.staff.domain.repository.StaffRepository;
import com.edutia.hopecare.staff.infrastructure.persistence.entity.StaffEntity;
import com.edutia.hopecare.staff.infrastructure.persistence.mapper.StaffPersistenceMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@AllArgsConstructor
public class StaffRepositoryImpl implements StaffRepository {

    private final StaffJpaRepository jpaRepository;
    private final StaffPersistenceMapper mapper;

    @Override
    public Staff save(Staff staff) {

        StaffEntity staffEntity = mapper.toEntity(staff);

        StaffEntity savedEntity = jpaRepository.save(staffEntity);

        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Staff> findById(Long id) {

         return jpaRepository.findById(id)
                 .map(mapper::toDomain);
    }

    @Override
    public Page<Staff> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable)
                .map(mapper::toDomain);

    }

    @Override
    public void deleteById(Long id) {

        jpaRepository.deleteById(id);

    }
}
