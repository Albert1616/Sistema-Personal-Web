package com.user.sistemaPersonal.rest.controller;

import com.user.sistemaPersonal.rest.dto.CredentialsDTO;
import com.user.sistemaPersonal.exception.SenhaInvalidaException;
import com.user.sistemaPersonal.entites.User;
import com.user.sistemaPersonal.rest.dto.CredentialsDTO;
import com.user.sistemaPersonal.rest.dto.UserRequestDTO;
import com.user.sistemaPersonal.security.JwtService;
import com.user.sistemaPersonal.service.UserService;
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

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody @Valid UserRequestDTO user){
        String passwordAfter = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordAfter);
        return userService.save(user);
    }

    @PostMapping("/auth")
    public String auth(@RequestBody CredentialsDTO credentialsDTO){
        try{
            User user = new User(credentialsDTO.getLogin(), credentialsDTO.getPassword());
            UserDetails userAuth = userService.auth(user);
            user = userService.getUserByLogin(user.getLogin());
            String token = jwtService.createToken(user);
            return token;
        }catch (UsernameNotFoundException | SenhaInvalidaException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
