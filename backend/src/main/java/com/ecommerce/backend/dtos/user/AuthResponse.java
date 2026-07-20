package com.ecommerce.backend.dtos.user;

public record AuthResponse(
        String token,
        String email,
        String role
) {}