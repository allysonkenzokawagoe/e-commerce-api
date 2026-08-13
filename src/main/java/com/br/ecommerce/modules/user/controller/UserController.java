package com.br.ecommerce.modules.user.controller;

import com.br.ecommerce.modules.user.dto.UserRequest;
import com.br.ecommerce.modules.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService service;

    @PostMapping
    public void createUser(@Valid @RequestBody UserRequest userRequest) {
        service.registerUser(userRequest);
    }
}
