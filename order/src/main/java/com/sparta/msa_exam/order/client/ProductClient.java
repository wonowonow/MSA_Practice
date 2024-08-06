package com.sparta.msa_exam.order.client;

import com.sparta.msa_exam.order.common.response.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient
public interface ProductClient {

    @GetMapping
    ResponseEntity<? extends CommonResponse> getProducts();
}
