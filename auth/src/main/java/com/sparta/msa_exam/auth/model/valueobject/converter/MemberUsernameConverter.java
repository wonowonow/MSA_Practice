package com.sparta.msa_exam.auth.model.valueobject.converter;

import com.sparta.msa_exam.auth.model.valueobject.MemberUsername;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MemberUsernameConverter implements AttributeConverter<MemberUsername, String> {

    @Override
    public String convertToDatabaseColumn(MemberUsername memberUsername) {

        if (memberUsername == null) {
            return null;
        }

        return memberUsername.value();
    }

    @Override
    public MemberUsername convertToEntityAttribute(String username) {

        if (username == null) {
            return null;
        }

        return new MemberUsername(username);
    }
}
