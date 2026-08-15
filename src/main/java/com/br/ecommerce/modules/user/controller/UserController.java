package com.br.ecommerce.modules.user.controller;

import com.br.ecommerce.modules.user.dto.UserRequest;
import com.br.ecommerce.modules.user.dto.UserResponse;
import com.br.ecommerce.modules.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService service;

    @PostMapping
    public void createUser(@Valid @RequestBody UserRequest userRequest) {
        service.registerUser(userRequest);
    }

    @GetMapping("{id}")
    public UserResponse getUser(@PathVariable Integer id) {
        return service.getUser(id);
    }
}
