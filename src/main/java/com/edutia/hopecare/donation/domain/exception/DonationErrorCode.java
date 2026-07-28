package com.edutia.hopecare.donation.domain.exception;

import com.edutia.hopecare.shared.exception.ErrorCode;

public enum DonationErrorCode  implements ErrorCode {

    INVALID_NAME(
            "DONATION_001",
            "name is invalid"
    ),
    INVALID_EMAIL(
            "DONATION_002",
            "email is invalid"
    ),
    INVALID_TYPE(
            "DONATION_003",
            "type is invalid"
    ),
    DONATION_NOT_FOUND(
            "DONAtION_004",
            "donation not found"
    );

    private final String code;
    private final String message;

    DonationErrorCode(String code, String message){
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
