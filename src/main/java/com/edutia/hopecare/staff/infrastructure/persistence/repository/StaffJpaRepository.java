package com.edutia.hopecare.staff.infrastructure.persistence.repository;

import com.edutia.hopecare.staff.infrastructure.persistence.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffJpaRepository extends JpaRepository<StaffEntity, Long> {
}
