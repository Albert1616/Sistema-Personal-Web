package com.personal.sistemaPersonal.rest.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class NutricionistaRequestDTO extends UserRequestDTO {
    @NotBlank(message = "Campo não informado.")
    private String nome;

    @Email(message = "Email inválido.")
    @NotBlank(message = "Campo não informado.")
    private String email;

    @Past(message = "Data de nascimento inválida.")
    private LocalDate data_nascimento;
}