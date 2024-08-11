package com.sparta.msa_exam.auth.common.message;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {

    SUCCESS_CREATE_TOKEN(CREATED, "Token Created Successfully"),
    SUCCESS_SIGN_UP(CREATED, "Sign Up Successfully");

    private final HttpStatus httpStatus;
    private final String message;
}
