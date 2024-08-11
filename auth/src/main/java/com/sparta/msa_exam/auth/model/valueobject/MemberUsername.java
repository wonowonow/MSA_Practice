package com.sparta.msa_exam.auth.model.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record MemberUsername (
        @Column(name = "username", nullable = false, unique = true)
        String value
) {

    public MemberUsername {
        if (value == null || value.isBlank() || value.length() < 3) {
            throw new IllegalArgumentException("Username needs at least 3 characters");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
