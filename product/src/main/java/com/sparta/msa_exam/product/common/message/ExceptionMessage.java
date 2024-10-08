package com.sparta.msa_exam.product.common.message;

import static org.springframework.http.HttpStatus.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {

    EXCEPTION_MESSAGE(BAD_REQUEST, "정의할 수 없는 오류 발생!");

    private final HttpStatus httpStatus;
    private final String message;
}
