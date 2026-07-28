package com.edutia.hopecare.staff.domain.exception;

import com.edutia.hopecare.shared.exception.ErrorCode;

public enum StaffErrorCode implements ErrorCode {
    INVALID_NAME(
                "STAFF_001",
                "name is invalid"
        ),
    INVALID_EMAIL(
            "STAFF_002",
            "email is invalid"
    ),
    STAFF_NOT_FOUND(
            "STAFF_003",
            "donation not found"
    ),
    INVALID_ROLE(
            "STAFF_004",
            "staffRole is null"
    );
    private final String code;
    private final String message;

    StaffErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
