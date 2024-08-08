package com.sparta.msa_exam.auth.common.exception;

import com.sparta.msa_exam.auth.common.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AuthException.class)
    public ResponseEntity<ErrorResponse> handleOrderException(AuthException e){

        return ResponseEntity.status(e.getHttpStatus()).body(ErrorResponse.of(e.getMessage()));
    }
}
