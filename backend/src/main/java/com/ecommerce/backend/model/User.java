package com.ecommerce.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "u_id", nullable = false)
    private UUID id;

    @NotBlank
    @Email
    @Column(name = "email_user", nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(name = "user_name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Pattern(regexp = "^\\+?[0-9\\s()-]{8,20}$")
    @Column(name = "phone_user", length = 20)
    private String phone;

    @NotBlank
    @Size(max = 50)
    @Column(name = "password", nullable = false, length = 50)
    private String password;
}
