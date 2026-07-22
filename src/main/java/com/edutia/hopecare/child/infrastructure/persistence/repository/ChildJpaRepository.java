package com.edutia.hopecare.child.infrastructure.persistence.repository;

import com.edutia.hopecare.child.infrastructure.persistence.entity.ChildEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildJpaRepository extends JpaRepository<ChildEntity,Long> {
}
