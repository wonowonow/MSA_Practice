package com.sparta.msa_exam.auth.model;

import com.sparta.msa_exam.auth.dto.SignUpDto;
import com.sparta.msa_exam.auth.model.valueobject.MemberUsername;
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
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private MemberUsername username;

    public static Member of(SignUpDto signUpDto) {

        return Member.builder()
                .username(new MemberUsername(signUpDto.username()))
                .build();
    }
}
