package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.dto.ProductCreateDto;
import com.sparta.msa_exam.product.dto.ProductResponseDto;
import com.sparta.msa_exam.product.model.Product;
import com.sparta.msa_exam.product.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImplV1 implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void createProduct(ProductCreateDto productCreateDto) {

        productRepository.save(Product.of(productCreateDto));
    }

    @Override
    public List<ProductResponseDto> getProducts() {

        return productRepository.getProductResponses();
    }
}
