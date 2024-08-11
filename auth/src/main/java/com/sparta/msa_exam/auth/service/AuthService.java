package com.sparta.msa_exam.auth.service;

import com.sparta.msa_exam.auth.dto.SignUpDto;

public interface AuthService {

    String signIn(String user_id);

    void signUp(SignUpDto signUpDto);
}
