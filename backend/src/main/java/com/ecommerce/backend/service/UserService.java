package com.ecommerce.backend.service;



import com.ecommerce.backend.dtos.user.UserResponse;
import com.ecommerce.backend.dtos.user.UserUpdateRequest;
import com.ecommerce.backend.model.User;
import com.ecommerce.backend.model.UserMapper;
import com.ecommerce.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserResponse getProfile(User currentUser) {
        return userMapper.toResponse(currentUser);
    }

    @Transactional
    public UserResponse updateProfile(User currentUser, UserUpdateRequest request) {
        // Recebe entidade e devolve dto
        // Copia dados pra entidade e salva
        userMapper.updateEntityFromDto(request, currentUser);
        userRepository.save(currentUser);
        return userMapper.toResponse(currentUser);
    }
}
