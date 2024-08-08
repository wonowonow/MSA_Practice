package com.sparta.msa_exam.order.client.response;

public abstract class CommonResponseData {

    private final boolean success;

    private final String message;

    public CommonResponseData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
