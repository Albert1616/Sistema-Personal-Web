package com.personal.sistemaPersonal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite acesso a todos os endpoints
                .allowedOrigins("http://localhost:3000") // Permite a origem do seu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // Permite os métodos HTTP necessários
                .allowedHeaders("*") // Permite todos os cabeçalhos
                .allowCredentials(true); // Permite o envio de credenciais (cookies, autorização)
    }
}

