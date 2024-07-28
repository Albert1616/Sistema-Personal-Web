package com.personal.sistemaPersonal.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.Token;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class TokenDTO {
    private Integer id;
    private String paper;
    private String token;

    public TokenDTO(Integer id, String paper, String token){
        this.id = id;
        this.paper = paper;
        this.token = token;
    }
}
