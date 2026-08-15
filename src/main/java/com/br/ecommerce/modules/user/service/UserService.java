package com.br.ecommerce.modules.user.service;

import com.br.ecommerce.modules.comum.exceptions.NotFoundException;
import com.br.ecommerce.modules.comum.exceptions.ValidacaoException;
import com.br.ecommerce.modules.user.dto.UserRequest;
import com.br.ecommerce.modules.user.dto.UserResponse;
import com.br.ecommerce.modules.user.model.User;
import com.br.ecommerce.modules.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public void registerUser(UserRequest request) {
        validarUser(request);
        var senhaCriptografada = encoder.encode(request.password());
        var user = User.of(request);
        user.setPassword(senhaCriptografada);

        repository.save(user);
    }

    public UserResponse getUser(Integer id) {
        return UserResponse.of(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found")));
    }

    @SneakyThrows
    private void validarUser(UserRequest request) {
        if (repository.existsByEmail(request.email())) {
            throw new ValidacaoException("It already exists a user with this e-mail!");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmailIgnoreCase(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
