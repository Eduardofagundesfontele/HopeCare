package com.edutia.hopecare.donation.domain.exception;

import com.edutia.hopecare.shared.exception.ErrorCode;

public enum DonationErroCode  implements ErrorCode {

    INVALID_NAME(
            "DONATION_001",
            "name is invalid"
    ),
    INVALID_EMAIL(
            "DONATION_002",
            "email is invalid"
    ),
    INVALID_TYPE(
            "DONARION_003",
            "type is invalid"
    ),
    DONATION_NOT_FOUND(
            "DONARION_004",
            "donation not found"
    );

    private final String code;
    private final String message;

    DonationErroCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return "";
    }

    @Override
    public String getMessage() {
        return "";
    }
}
