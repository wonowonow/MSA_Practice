package com.sparta.msa_exam.auth.controller;

import static com.sparta.msa_exam.auth.common.message.SuccessMessage.SUCCESS_CREATE_TOKEN;
import static com.sparta.msa_exam.auth.common.response.SuccessResponse.success;

import com.sparta.msa_exam.auth.common.response.CommonResponse;
import com.sparta.msa_exam.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/signIn")
    public ResponseEntity<? extends CommonResponse> signIn(@RequestParam String user_id) {

        return ResponseEntity.status(SUCCESS_CREATE_TOKEN.getHttpStatus())
                .body(success(SUCCESS_CREATE_TOKEN.getMessage(), authService.createAccessToken(user_id)));
    }
}
