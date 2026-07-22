package com.edutia.hopecare.child.presentation.controller;

import com.edutia.hopecare.child.application.usecase.*;
import com.edutia.hopecare.child.presentation.dto.request.CreateChildRequest;
import com.edutia.hopecare.child.presentation.dto.request.UpdateChildRequest;
import com.edutia.hopecare.child.presentation.dto.response.ChildResponse;
import com.edutia.hopecare.child.presentation.mapper.ChildPresentationMapper;
import com.edutia.hopecare.donation.presentation.dto.response.DonationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("children")
@RequiredArgsConstructor
public class ChildController {

    private final CreateChildUseCase createChildUseCase;
    private final FindAllChildUseCase findAllChildUseCase;
    private final FindChildByIdUseCase childByIdUseCase;
    private final UpdateChildUseCase updateChildUseCase;
    private final DeleteChildUseCase deleteChildUseCase;
    private final ChildPresentationMapper childPresentationMapper;

    @PostMapping
    public ResponseEntity<ChildResponse> create(@Valid @RequestBody CreateChildRequest request){

        final var child = createChildUseCase.execute(childPresentationMapper.toDomain(request));

        return ResponseEntity
                .created(URI.create("/children/" + child.getId()))
                .body(childPresentationMapper.toResponse(child));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ChildResponse> findById(@PathVariable Long id){

        final var child = childByIdUseCase.execute(id);
        return  ResponseEntity.ok(childPresentationMapper.toResponse(child));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ChildResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateChildRequest request){

        final var child = updateChildUseCase.execute(id,childPresentationMapper.toDomainUpdate(request));

        return ResponseEntity.ok(childPresentationMapper.toResponse(child));
    }
    @GetMapping
    public ResponseEntity<Page<ChildResponse>> findAll(Pageable pageable){

        Page<ChildResponse> children = findAllChildUseCase.execute(pageable)
                .map(childPresentationMapper::toResponse);

        return ResponseEntity.ok(children);


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        deleteChildUseCase.execute(id);

        return ResponseEntity.noContent().build();
    }


}
