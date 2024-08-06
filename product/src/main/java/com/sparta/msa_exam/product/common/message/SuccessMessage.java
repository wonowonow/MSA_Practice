package com.sparta.msa_exam.product.common.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {

    SUCCESS_CREATE_PRODUCT(HttpStatus.CREATED, "Product created successfully"),
    SUCCESS_GET_PRODUCTS(HttpStatus.OK, "Get products successfully"),;

    private final HttpStatus httpStatus;
    private final String message;
}
