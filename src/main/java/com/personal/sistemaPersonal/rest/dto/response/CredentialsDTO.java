package com.personal.sistemaPersonal.rest.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredentialsDTO {
    private String login;
    private String password;

    public String getLogin(){
        return this.login;
    }
    public String getPassword(){
        return this.password;
    }
}
