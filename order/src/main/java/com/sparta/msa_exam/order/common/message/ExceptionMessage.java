package com.sparta.msa_exam.order.common.message;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {

    NOT_FOUND_PRODUCT(NOT_FOUND, "Product not found"),
    EXCEPTION_MESSAGE(BAD_REQUEST, "정의할 수 없는 오류 발생!"),
    NOT_FOUND_ORDER(NOT_FOUND, "Order not found"),;

    private final HttpStatus httpStatus;
    private final String message;
}
