package com.personal.sistemaPersonal.config;

import com.personal.sistemaPersonal.security.JwtAuthFilter;
import com.personal.sistemaPersonal.security.JwtService;
import com.personal.sistemaPersonal.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
        return new JwtAuthFilter(jwt, userService);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((authz)->
                authz.requestMatchers(
                        "/v3/api-docs/***",
                        "/swagger-resources/**",
                        "/swagger-ui/**")
                        .permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/user/**")
                            .permitAll()
                        .requestMatchers("/api/aluno/**")
                            .hasAnyRole("ADMIN", "PERSONAL", "NUTRICIONISTA")
                        .requestMatchers("/api/personal/**")
                            .hasAnyRole("ADMIN")
                        .requestMatchers("/api/nutricionista/**")
                            .hasAnyRole("ADMIN")
                        .requestMatchers("/api/")
                ))
        //continuar daqui aplicando o tipo de permisão de cada rota
    }
}
