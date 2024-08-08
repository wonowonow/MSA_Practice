package com.sparta.msa_exam.order.client;

import com.sparta.msa_exam.order.client.response.ProductsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/products")
    ProductsResponse getProducts();
}
