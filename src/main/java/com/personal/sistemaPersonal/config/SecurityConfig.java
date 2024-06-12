package com.personal.sistemaPersonal.config;

import com.personal.sistemaPersonal.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private JwtService jwt;
    @Autowired
    private UserService userService;

    @Bean
    public OncePerRequestFilter jwtFilter(){
        return new JwtAuthFilter(JwtService, userService);
    }
}
