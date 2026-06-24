package com.edutia.hopecare.child.domain.repository;

import com.edutia.hopecare.child.domain.model.Child;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ChildRepository {

    Child save(Child child);

    Optional<Child> findById(Long id);

    Page<Child> findAll(Pageable pageable);

    void deleteById(Long id);


}
