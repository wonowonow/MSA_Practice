package com.sparta.msa_exam.auth.common.exception;

import com.sparta.msa_exam.auth.common.message.ExceptionMessage;
import org.springframework.http.HttpStatus;

public class AuthException extends RuntimeException {

    private final ExceptionMessage exceptionMessage;

    public AuthException(ExceptionMessage exceptionMessage) {
        super("[Auth Exception]: " + exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }

    public HttpStatus getHttpStatus() {

        return exceptionMessage.getHttpStatus();
    }

    public String getMessage() {

        return exceptionMessage.getMessage();
    }
}
