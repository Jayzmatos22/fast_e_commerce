package com.ecommerce.backend.dtos;

public record AuthResponse(
        String token,
        String email,
        String role
) {}