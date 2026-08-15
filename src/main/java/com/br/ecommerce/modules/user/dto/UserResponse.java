package com.br.ecommerce.modules.user.dto;

import com.br.ecommerce.modules.user.model.User;

import java.time.LocalDateTime;

public record UserResponse(
        Integer id,
        String name,
        String email,
        LocalDateTime createdAt
) {
    public static UserResponse of(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getCreatedAt());
    }
}
