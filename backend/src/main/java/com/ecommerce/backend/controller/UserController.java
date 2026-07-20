package com.ecommerce.backend.controller;

import com.ecommerce.backend.dtos.user.UserResponse;
import com.ecommerce.backend.dtos.user.UserUpdateRequest;
import com.ecommerce.backend.model.User;
import com.ecommerce.backend.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getMe(@AuthenticationPrincipal User currentUser) {
        return ResponseEntity.ok(userService.getProfile(currentUser));
    }

    @PutMapping("/me")
    ResponseEntity<UserResponse> updateMe(
            @AuthenticationPrincipal User currentUser,
            @RequestBody @Valid UserUpdateRequest request){
        return ResponseEntity.ok(userService.updateProfile(currentUser, request));
    }


    @DeleteMapping("/delete")
    ResponseEntity<Void> deleteMe(@AuthenticationPrincipal User currentUser) {
        userService.deleteUser(currentUser);
        return ResponseEntity.noContent().build();
    }


}
