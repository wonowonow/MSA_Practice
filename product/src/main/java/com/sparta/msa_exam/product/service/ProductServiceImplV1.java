package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.dto.ProductCreateDto;
import com.sparta.msa_exam.product.dto.ProductResponseDto;
import com.sparta.msa_exam.product.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImplV1 implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void createProduct(ProductCreateDto productCreateDto) {

    }

    @Override
    public List<ProductResponseDto> getProducts() {
        return List.of();
    }
}
