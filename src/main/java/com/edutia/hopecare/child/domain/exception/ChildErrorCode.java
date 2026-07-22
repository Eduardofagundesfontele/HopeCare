package com.edutia.hopecare.child.domain.exception;

import com.edutia.hopecare.shared.exception.ErrorCode;

public enum ChildErrorCode implements ErrorCode {
    INVALID_NAME(
            "CHILD_001",
            "child name is invalid"
    ),
    INVALID_BIRTH_DATE(
            "CHILD_002",
            "child birth date is invalid"
    ),
    INVALID_GENDER(
            "CHILD_003",
            "child gender is invalid"
    ),
    INVALID_NATIONALITY(
            "CHILD_004",
            "child natiolity is invalid"
    ),
    CHILD_NOT_FOUND(
            "CHILD_005",
            "Child not found");

    private final String code;
    private final String message;

    ChildErrorCode(String code, String message){
        this.code=code;
        this.message=message;
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
