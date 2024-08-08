package com.sparta.msa_exam.product.dto;

public record ProductResponseDto(
        Long product_id,
        String name,
        Integer supply_price
) {

}
