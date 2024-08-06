package com.sparta.msa_exam.product.model.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record ProductName(
        @Column(name = "name", nullable = false)
        String value
) {

    public ProductName {
        if (value == null || value.isBlank() || value.length() < 3) {
            throw new IllegalArgumentException("Product name must have at least 3 characters");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
