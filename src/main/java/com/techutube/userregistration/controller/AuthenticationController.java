package com.techutube.userregistration.controller;

import com.techutube.userregistration.dto.JwtAuthenticationResponse;
import com.techutube.userregistration.dto.RefreshTokenRequest;
import com.techutube.userregistration.dto.SignInRequest;
import com.techutube.userregistration.dto.SignUpRequest;
import com.techutube.userregistration.entity.User;
import com.techutube.userregistration.service.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private final AuthenticationServiceImpl authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }

    @PostMapping("/admin-signup")
    public ResponseEntity<User> adminSignUp(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.adminSignUp(signUpRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }


    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }

}
