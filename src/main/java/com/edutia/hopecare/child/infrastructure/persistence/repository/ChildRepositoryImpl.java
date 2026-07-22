package com.edutia.hopecare.child.infrastructure.persistence.repository;

import com.edutia.hopecare.child.domain.model.Child;
import com.edutia.hopecare.child.domain.repository.ChildRepository;
import com.edutia.hopecare.child.infrastructure.persistence.entity.ChildEntity;
import com.edutia.hopecare.child.infrastructure.persistence.mapper.ChildPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class ChildRepositoryImpl implements ChildRepository {

    private final ChildJpaRepository jpaRepository;
    private final ChildPersistenceMapper mapper;

    @Override
    public Child save(Child child) {

        ChildEntity entity = mapper.toEntity(child);

        ChildEntity savedEntity = jpaRepository.save(entity);

        return mapper.toDomain(savedEntity);

    }

    @Override
    public Optional<Child> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Page<Child> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable)
                .map(mapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);

    }
}
