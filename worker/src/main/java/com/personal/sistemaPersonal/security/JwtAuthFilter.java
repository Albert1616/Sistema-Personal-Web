package com.personal.sistemaPersonal.security;

import com.personal.sistemaPersonal.config.SecurityConfig;
import com.personal.sistemaPersonal.service.impl.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Arrays;

public class JwtAuthFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserService userService;

    public JwtAuthFilter(JwtService jwtService, UserService userService){
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(checkIfEndpointIsNotPublic(request)){
            String authorization = recoveryToken(request);
            if(authorization != null){
                boolean isValid = jwtService.tokenValido(authorization);

                if(isValid){
                    String login = jwtService.obterLoginUsuario(authorization);
                    UserDetails user = userService.loadUserByUsername(login);
                    UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(
                            user, null, user.getAuthorities()
                    );
                    userToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(userToken);
                }
                else{
                    throw new RuntimeException("Token inválido");
                }
            }
            else{
                throw new RuntimeException("Informe o token com o prefixo Bearer");
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoveryToken(HttpServletRequest request){
        String authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")){
            return authorizationHeader.split(" ")[1];
        }
        return null;
    }

    private boolean checkIfEndpointIsNotPublic(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        return !(Arrays.asList(SecurityConfig.ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED).contains(requestURI) || requestURI.startsWith("/swagger-ui") || requestURI.startsWith("/swagger-resources") || requestURI.startsWith("/api-docs"));
    }
}
