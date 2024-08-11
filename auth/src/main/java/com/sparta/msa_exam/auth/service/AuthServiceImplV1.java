package com.sparta.msa_exam.auth.service;

import com.sparta.msa_exam.auth.common.exception.AuthException;
import com.sparta.msa_exam.auth.common.message.ExceptionMessage;
import com.sparta.msa_exam.auth.dto.SignUpDto;
import com.sparta.msa_exam.auth.model.Member;
import com.sparta.msa_exam.auth.model.valueobject.MemberUsername;
import com.sparta.msa_exam.auth.repository.MemberRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthServiceImplV1 implements AuthService {

    private final MemberRepository memberRepository;

    @Value("${spring.application.name}")
    private String issuer;

    @Value("${service.jwt.access-expiration}")
    private Long accessExpiration;

    private final SecretKey secretKey;

    public AuthServiceImplV1(@Value("${service.jwt.secret-key}") String secretKey, MemberRepository memberRepository) {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
        this.memberRepository = memberRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public String signIn(String user_id) {

        if (!memberRepository.existsByUsername(new MemberUsername(user_id))) {
            throw new AuthException(ExceptionMessage.NOT_FOUND_MEMBER);
        }

        return Jwts.builder()
                .claim("user_id", user_id)
                .issuer(issuer)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + accessExpiration))
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();
    }

    @Override
    @Transactional
    public void signUp(SignUpDto signUpDto) {

        if (memberRepository.existsByUsername(new MemberUsername(signUpDto.username()))) {
            throw new AuthException(ExceptionMessage.CONFLICT_MEMBER_USERNAME);
        }

        memberRepository.save(Member.of(signUpDto));
    }
}
