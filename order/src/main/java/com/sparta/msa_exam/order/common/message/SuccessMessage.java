package com.sparta.msa_exam.order.common.message;

import static org.springframework.http.HttpStatus.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {

    SUCCESS_CREATE_ORDER(CREATED, "Order created successfully"),
    SUCCESS_GET_ORDER(OK, "Get order successfully"),
    SUCCESS_EDIT_ORDER(OK, "Edit order successfully"),;

    private final HttpStatus httpStatus;
    private final String message;
}
