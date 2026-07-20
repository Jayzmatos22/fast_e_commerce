package com.ecommerce.backend.dtos.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserUpdateRequest(

        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String name,

        @Size(min = 11, max = 20, message = "O telefone deve ter entre 11 e 20 caracteres!")
        String phoneUser,

        @Past(message = "A data de nascimento deve ser uma data passada")
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate birthDate
) {
}
