package com.sparta.msa_exam.product.dto;

import com.sparta.msa_exam.product.model.Product;
import java.io.Serializable;
import lombok.Builder;

@Builder
public record ProductResponseDto (
        Long product_id,
        String name,
        Integer supply_price
) implements Serializable {

    public static ProductResponseDto fromEntity(Product product) {
        return ProductResponseDto.builder()
                                 .product_id(product.getProductId())
                                 .name(product.getName().value())
                                 .supply_price(product.getSupplyPrice().value())
                                 .build();
    }
}
