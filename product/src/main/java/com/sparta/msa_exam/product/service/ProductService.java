package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.dto.ProductCreateDto;
import com.sparta.msa_exam.product.dto.ProductResponseDto;
import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(ProductCreateDto productCreateDto);

    List<ProductResponseDto> getProducts();
}
