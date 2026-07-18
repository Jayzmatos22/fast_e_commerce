package com.ecommerce.backend.dtos.user;

import java.time.LocalDate;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String name,
        String email,
        String phoneUser,
        LocalDate birthDate,
        String role
) {
}
