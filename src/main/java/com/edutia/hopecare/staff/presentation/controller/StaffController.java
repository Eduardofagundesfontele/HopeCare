package com.edutia.hopecare.staff.presentation.controller;

import com.edutia.hopecare.staff.application.useCase.*;
import com.edutia.hopecare.staff.presentation.dto.request.CreateStaffRequest;
import com.edutia.hopecare.staff.presentation.dto.request.UpdateStaffRequest;
import com.edutia.hopecare.staff.presentation.dto.response.StaffResponse;
import com.edutia.hopecare.staff.presentation.mapper.StaffPresentationMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("staffs")
@RequiredArgsConstructor
public class StaffController {

    private final CreateStaffUseCase createStaffUseCase;
    private final UpdateStaffUseCase updateStaffUseCase;
    private final FindAllStaffUseCase findAllStaffUseCase;
    private final FindStaffByIdUseCase findStaffByIdUseCase;
    private final DeleteStaffUseCase deleteStaffUseCase;
    private final StaffPresentationMapper mapper;

    @PostMapping
    public ResponseEntity<StaffResponse> create (@Valid @RequestBody CreateStaffRequest request){

        final var staff = createStaffUseCase.execute(mapper.toDomain(request));

        return ResponseEntity.created(URI.create("/staffs/" + staff.getId()))
                .body(mapper.toResponse(staff));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffResponse> findById (@PathVariable Long id){

        final var staff = findStaffByIdUseCase.execute(id);

        return ResponseEntity.ok(mapper.toResponse(staff));
    }
    @GetMapping
    public ResponseEntity<Page<StaffResponse>> findAll (Pageable pageable){

        Page<StaffResponse> staffs = findAllStaffUseCase.execute(pageable)
                .map(mapper::toResponse);

        return  ResponseEntity.ok(staffs);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StaffResponse> updateStaff(@PathVariable Long id, @Valid @RequestBody UpdateStaffRequest request){

        final var staff = updateStaffUseCase.execute(id,mapper.toDomainUpdate(request));

        return ResponseEntity.ok(mapper.toResponse(staff));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){

        deleteStaffUseCase.execute(id);

        return ResponseEntity.noContent().build();

    }


}
