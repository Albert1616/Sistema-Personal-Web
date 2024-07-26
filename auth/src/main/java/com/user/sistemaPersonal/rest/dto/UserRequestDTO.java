package com.user.sistemaPersonal.rest.dto;

import com.user.sistemaPersonal.enumerate.UserTypes;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    @NotBlank(message = "Campo não informado.")
    private String login;

    @NotBlank(message = "Campo não informado.")
    private String password;

    private UserTypes paper;

}
