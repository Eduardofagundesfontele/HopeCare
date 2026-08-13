package com.edutia.hopecare.staff.domain.model;


import com.edutia.hopecare.shared.exception.DomainException;
import com.edutia.hopecare.staff.domain.exception.StaffErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = "id")
public class Staff {
  private   Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private StaffRole staffRole;
    private LocalDate hireDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected Staff(){};

    //CREATE
        public static Staff create(
                String name,
                String email,
                String phoneNumber,
                StaffRole staffRole,
                LocalDate hireDate
                ){

            validate(
                    name,
                    email,
                   staffRole
            );
            Staff staff = new Staff();
            staff.name=name;
            staff.email=email;
            staff.phoneNumber=phoneNumber;
            staff.staffRole = staffRole;
            staff.hireDate = hireDate;

            return staff;
        }

        //RECONSTRUCT
     public static Staff reconstruct(
             Long id,
             String name,
             String email,
             String phoneNumber,
             StaffRole staffRole,
             LocalDate hireDate,
             LocalDateTime createdAt,
             LocalDateTime updatedAt
    ){
        Staff staff = new Staff();

         staff.id = id;
         staff.name = name;
         staff.email = email;
         staff.phoneNumber = phoneNumber;
         staff.staffRole = staffRole;
         staff.hireDate = hireDate;
         staff.createdAt = createdAt;
         staff.updatedAt = updatedAt;

         return staff;
     }

     //UPDATE
    public void update(
            String name,
            String email,
            String phoneNumber,
            StaffRole staffRole

    ){
        validate(
                name,
                email,
                staffRole
        );
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.staffRole = staffRole;
    }

    private static void validate(
            String name,
            String email,
            StaffRole staffRole){
        if(name == null || name.isBlank()){
            throw new DomainException(StaffErrorCode.INVALID_NAME);
        }
        if(email == null || email.isBlank()){
            throw new DomainException(StaffErrorCode.INVALID_EMAIL);
        }
        if (staffRole == null){
            throw new DomainException(StaffErrorCode.INVALID_ROLE);
        }
    }



    }




