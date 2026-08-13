package com.br.ecommerce.modules.user.service;

import com.br.ecommerce.modules.user.dto.UserRequest;
import com.br.ecommerce.modules.user.model.User;
import com.br.ecommerce.modules.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public void registerUser(UserRequest request) {
        validarUser(request);
        var user = User.of(request);

        repository.save(user);
    }

    @SneakyThrows
    private void validarUser(UserRequest request) {
        if (repository.existsByEmail(request.email())) {
            throw new Exception("It already exists a user with this e-mail!");
        }
    }
}
