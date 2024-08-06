package com.sparta.msa_exam.order.model.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record OrderName(
        @Column(name = "name", nullable = false)
        String value
) {
    public OrderName {
        if (value == null || value.isBlank() || value.length() < 3) {
            throw new IllegalArgumentException("Order name needs at least 3 characters");
        }
    }
}
