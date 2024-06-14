package com.personal.sistemaPersonal.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.Token;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class TokenDTO {
    private String login;
    private String token;

    public TokenDTO(String login, String token){
        this.login = login;
        this.token = token;
    }
}
