package com.ecommerce.backend.dtos.user;

import java.time.LocalDate;

public record UserUpdateRequest(
        String name,
        String phoneUser,
        LocalDate birthDate
) {
}
