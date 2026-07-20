package com.ecommerce.backend.controller;


import com.ecommerce.backend.dtos.user.AuthResponse;
import com.ecommerce.backend.dtos.user.LoginRequest;
import com.ecommerce.backend.dtos.user.RegisterRequest;
import com.ecommerce.backend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest registerRequest){
        return ResponseEntity.ok(authService.register(registerRequest));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }





}
