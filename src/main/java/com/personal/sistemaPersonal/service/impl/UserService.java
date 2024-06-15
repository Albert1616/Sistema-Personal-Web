package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.enumerate.UserTypes;
import com.personal.sistemaPersonal.exception.SenhaInvalidaException;
import com.personal.sistemaPersonal.exception.UsuarioNaoEncontrado;
import com.personal.sistemaPersonal.model.User;
import com.personal.sistemaPersonal.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static com.personal.sistemaPersonal.enumerate.UserTypes.*;

@Component

public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository repository;

    @Transactional
    public User save(User user){
        return repository.save(user);
    }

    public UserDetails auth(User user){
        UserDetails userAuth = loadUserByUsername(user.getLogin());
        boolean passwordMatch = passwordEncoder.matches(user.getPassword(), userAuth.getPassword());

        if(passwordMatch){
            return userAuth;
        }

        throw new SenhaInvalidaException();
    }

    public UserDetails loadUserByUsername(String userLogin){
        User user = repository.findByLogin(userLogin)
                .orElseThrow(() -> new UsuarioNaoEncontrado());

        String[] roles = new String[] {user.getPaper().name(), "USER"};

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(roles)
                .build();
    }
}
