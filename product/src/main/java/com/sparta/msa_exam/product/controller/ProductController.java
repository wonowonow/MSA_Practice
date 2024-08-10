package com.sparta.msa_exam.product.controller;

import static com.sparta.msa_exam.product.common.message.SuccessMessage.*;
import static com.sparta.msa_exam.product.common.response.SuccessResponse.*;

import com.sparta.msa_exam.product.common.message.SuccessMessage;
import com.sparta.msa_exam.product.common.response.CommonResponse;
import com.sparta.msa_exam.product.common.response.SuccessResponse;
import com.sparta.msa_exam.product.dto.ProductCreateDto;
import com.sparta.msa_exam.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<? extends CommonResponse> createProduct(@RequestBody ProductCreateDto productCreateDto) {

        return ResponseEntity.status(SUCCESS_CREATE_PRODUCT.getHttpStatus())
                             .body(success(SUCCESS_CREATE_PRODUCT.getMessage(), productService.createProduct(productCreateDto)));
    }

    @GetMapping("/products")
    public ResponseEntity<? extends CommonResponse> getProducts() {

        return ResponseEntity.status(SUCCESS_GET_PRODUCTS.getHttpStatus())
                             .body(success(SUCCESS_GET_PRODUCTS.getMessage(), productService.getProducts()));
    }
}
