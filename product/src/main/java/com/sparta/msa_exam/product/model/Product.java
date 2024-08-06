package com.sparta.msa_exam.product.model;

import com.sparta.msa_exam.product.dto.ProductCreateDto;
import com.sparta.msa_exam.product.model.valueobject.ProductName;
import com.sparta.msa_exam.product.model.valueobject.ProductSupplyPrice;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Embedded
    private ProductName name;

    @Embedded
    private ProductSupplyPrice supplyPrice;

    public static Product of(ProductCreateDto productCreateDto) {

        return Product.builder()
                      .name(new ProductName(productCreateDto.name()))
                      .supplyPrice(new ProductSupplyPrice(productCreateDto.supplyPrice()))
                      .build();
    }
}
