package com.sparta.msa_exam.auth.common.message;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {

    NOT_FOUND_MEMBER(NOT_FOUND, "Not found member"),

    CONFLICT_MEMBER_USERNAME(CONFLICT, "The Username is already in use"),

    EXCEPTION_MESSAGE(BAD_REQUEST, "정의할 수 없는 오류 발생!");

    private final HttpStatus httpStatus;
    private final String message;
}
