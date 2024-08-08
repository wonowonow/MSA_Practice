package com.sparta.msa_exam.order.common.exception;

import com.sparta.msa_exam.order.common.message.ExceptionMessage;
import org.springframework.http.HttpStatus;

public class OrderProductException extends RuntimeException {

    private final ExceptionMessage exceptionMessage;

    public OrderProductException(ExceptionMessage exceptionMessage) {
        super("[OrderProduct Exception]: " + exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }

    public HttpStatus getHttpStatus() {

        return exceptionMessage.getHttpStatus();
    }

    public String getMessage() {

        return exceptionMessage.getMessage();
    }
}
