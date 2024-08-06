package com.sparta.msa_exam.product.common.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.sparta.msa_exam.product.common.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ProductException.class)
    public ResponseEntity<ErrorResponse> handleProductException(ProductException e){

        return ResponseEntity.status(e.getHttpStatus()).body(ErrorResponse.of(e.getMessage()));
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e){

        return ResponseEntity.status(BAD_REQUEST).body(ErrorResponse.of(e.getMessage()));
    }
}
