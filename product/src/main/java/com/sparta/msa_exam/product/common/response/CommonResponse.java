package com.sparta.msa_exam.product.common.response;

import lombok.NonNull;

public interface CommonResponse {

    boolean success();

    @NonNull
    String message();
}