package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.exception.SenhaInvalidaException;
import com.personal.sistemaPersonal.exception.UsuarioNaoEncontrado;
import com.personal.sistemaPersonal.model.User;
import com.personal.sistemaPersonal.repository.UserRepository;
import com.personal.sistemaPersonal.rest.dto.request.UserRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository repository;

    @Transactional
    public User save(UserRequestDTO dto){
        User user = new User();
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        user.setPaper(dto.getPaper());

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

    public User getByLogin(String login){
        Optional<User> user = repository.findByLogin(login);
        if(user.isPresent()){
            return repository.findByLogin(login).get();
        }
        throw new UsuarioNaoEncontrado();
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

    public User getUserByLogin(String login){
        Optional<User> user = repository.findByLogin(login);
        return user.orElseThrow(UsuarioNaoEncontrado::new);
    }
}
