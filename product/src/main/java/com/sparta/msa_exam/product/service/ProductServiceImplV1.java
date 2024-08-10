package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.dto.ProductCreateDto;
import com.sparta.msa_exam.product.dto.ProductResponseDto;
import com.sparta.msa_exam.product.model.Product;
import com.sparta.msa_exam.product.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImplV1 implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @CacheEvict(cacheNames = "productsCache", key = "'getProducts'")
    @Transactional
    public ProductResponseDto createProduct(ProductCreateDto productCreateDto) {

        return ProductResponseDto.fromEntity(productRepository.save(Product.of(productCreateDto)));
    }

    @Override
    @Cacheable(cacheNames = "productsCache", key = "'getProducts'")
    @Transactional(readOnly = true)
    public List<ProductResponseDto> getProducts() {

        return productRepository.getProductResponses();
    }

}
