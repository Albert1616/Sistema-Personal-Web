package com.personal.sistemaPersonal.rest.dto.request;

import com.personal.sistemaPersonal.enumerate.UserTypes;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequestDTO {
    @NotBlank(message = "Campo não informado.")
    private String login;

    @NotBlank(message = "Campo não informado.")
    private String password;

    private UserTypes paper;

}
