package com.sparta.msa_exam.product.dto;

public record ProductResponseDto(
        Long productId,
        String name,
        Integer supplyPrice
) {

}
