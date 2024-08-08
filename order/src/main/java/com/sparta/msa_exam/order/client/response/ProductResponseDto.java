package com.sparta.msa_exam.order.client.response;

public record ProductResponseDto (
        Long product_id,
        String name,
        Integer supply_price
) {

}
