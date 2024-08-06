package com.sparta.msa_exam.order.common.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {

    SUCCESS_CREATE_PRODUCT(HttpStatus.CREATED, "Order created successfully"),
    SUCCESS_GET_PRODUCTS(HttpStatus.OK, "Get orders successfully"),;

    private final HttpStatus httpStatus;
    private final String message;
}