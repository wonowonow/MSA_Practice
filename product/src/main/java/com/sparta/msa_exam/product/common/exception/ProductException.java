package com.sparta.msa_exam.product.common.exception;

import com.sparta.msa_exam.product.common.message.ExceptionMessage;
import org.springframework.http.HttpStatus;

public class ProductException extends RuntimeException {

    private final ExceptionMessage exceptionMessage;

    public ProductException(ExceptionMessage exceptionMessage) {
        super("[Product Exception]: " + exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }

    public HttpStatus getHttpStatus() {

        return exceptionMessage.getHttpStatus();
    }

    public String getMessage() {

        return exceptionMessage.getMessage();
    }
}
