package com.edutia.hopecare.donation.presentation.controller;

import com.edutia.hopecare.donation.application.usecase.*;
import com.edutia.hopecare.donation.presentation.dto.request.CreateDonationRequest;
import com.edutia.hopecare.donation.presentation.dto.request.UpdateDonationRequest;
import com.edutia.hopecare.donation.presentation.dto.response.DonationResponse;
import com.edutia.hopecare.donation.presentation.mapper.DonationPresentationMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("donations")
@RequiredArgsConstructor
public class DonationController {

    private final CreateDonationUseCase createDonationUseCase;
    private final UpdateDonationUseCase updateDonationUseCase;
    private final FindDonationIdUseCase findDonationIdUseCase;
    private final FindAllDonationUseCase findAllDonationUseCase;
    private final DeleteDonationUserCase deleteDonationUseCase;
    private final DonationPresentationMapper presentationMapper;

    @PostMapping
    public ResponseEntity<DonationResponse> create (@Valid @RequestBody CreateDonationRequest request){

        final var donation = createDonationUseCase.execute(presentationMapper.toDomain(request));

      return ResponseEntity.created(URI.create("/donations/" + donation.getId()))
              .body(presentationMapper.toResponse(donation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonationResponse> findById(@PathVariable Long id){

        final var donation = findDonationIdUseCase.execute(id);

        return ResponseEntity.ok(presentationMapper.toResponse(donation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonationResponse> updateDonation(@PathVariable Long id,@Valid @RequestBody UpdateDonationRequest request){

        final var donation = updateDonationUseCase.execute(id,presentationMapper.toDomainUpdate(request));

        return ResponseEntity.ok(presentationMapper.toResponse(donation));
    }

    @GetMapping
    public ResponseEntity<Page<DonationResponse>>findAll(Pageable pageable){

        Page<DonationResponse> donations = findAllDonationUseCase.execute(pageable)

                .map(presentationMapper::toResponse);

        return ResponseEntity.ok(donations);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonation(@PathVariable Long id){

        deleteDonationUseCase.execute(id);

        return ResponseEntity.noContent().build();


    }





}
