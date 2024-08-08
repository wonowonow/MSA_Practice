package com.sparta.msa_exam.auth.common.response;

import lombok.NonNull;

public interface CommonResponse {

    boolean success();

    @NonNull
    String message();
}