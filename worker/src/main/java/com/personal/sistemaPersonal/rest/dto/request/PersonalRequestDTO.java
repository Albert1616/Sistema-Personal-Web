package com.personal.sistemaPersonal.rest.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonalRequestDTO extends UserRequestDTO{
    @NotBlank(message = "Campo não informado.")
    private String nome;

    @Email(message = "Email inválido.")
    @NotBlank(message = "Campo não informado.")
    private String email;

    @Past(message = "Data de nascimento inválida.")
    private LocalDate dataNascimento;
}
