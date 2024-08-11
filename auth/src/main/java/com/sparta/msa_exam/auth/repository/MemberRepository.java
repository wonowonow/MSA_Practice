package com.sparta.msa_exam.auth.repository;

import com.sparta.msa_exam.auth.model.Member;
import com.sparta.msa_exam.auth.model.valueobject.MemberUsername;
import jakarta.persistence.Converter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 컨버터가 제대로 작동하지 않는 관계로, 값 객체 우선 선언
    boolean existsByUsername(@Param("username") MemberUsername username);
//    boolean existsByUsername(String username);
}
