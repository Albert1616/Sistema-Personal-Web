package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.exception.SenhaInvalidaException;
import com.personal.sistemaPersonal.model.User;
import com.personal.sistemaPersonal.rest.dto.request.UserRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.CredentialsDTO;
import com.personal.sistemaPersonal.rest.dto.response.TokenDTO;
import com.personal.sistemaPersonal.security.JwtService;
import com.personal.sistemaPersonal.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody @Valid UserRequestDTO user){
        String passwordAfter = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordAfter);
        return userService.save(user);
    }

    @PostMapping("/auth")
    public TokenDTO auth(@RequestBody CredentialsDTO credentialsDTO){
        try{
            User user = new User(credentialsDTO.getLogin(), credentialsDTO.getPassword());
            UserDetails userAuth = userService.auth(user);
            String token = jwtService.createToken(user);
            return new TokenDTO(user.getLogin(), token);
        }catch (UsernameNotFoundException | SenhaInvalidaException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
