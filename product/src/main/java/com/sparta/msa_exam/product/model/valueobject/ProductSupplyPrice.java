package com.sparta.msa_exam.product.model.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record ProductSupplyPrice (
        @Column(name = "supply_price", nullable = false)
        Integer value
) {

    public ProductSupplyPrice {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Supply price cannot be null or negative");
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
