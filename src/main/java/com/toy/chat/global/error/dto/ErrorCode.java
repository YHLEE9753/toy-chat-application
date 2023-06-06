package com.toy.chat.global.error.dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {

    //common
    INVALID_METHOD_ARGUMENT("C001", "Invalid method argument", HttpStatus.BAD_REQUEST),
    UNKNOWN_SERVER_ERROR("C002", "Unknown server error", HttpStatus.INTERNAL_SERVER_ERROR),
    METHOD_NOT_ALLOWED("C003", "Http method not allowed", HttpStatus.METHOD_NOT_ALLOWED),

    //member
    INVALID_EMAIL("M001", "Invalid email", HttpStatus.BAD_REQUEST),
    NOT_FOUND_MEMBER("M002", "Not found member", HttpStatus.BAD_REQUEST),
    NICKNAME_DUPLICATION("M003", "Nickname duplication", HttpStatus.BAD_REQUEST),
    REGISTERED_MEMBER("M004", "Member is already registered", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    ErrorCode(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}