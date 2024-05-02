package com.personal.sistemaPersonal.rest.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class AlunoRequestDTO {
    @NotBlank(message = "Campo não informado.")
    private String nome;

    @NotBlank(message = "Campo não informado.")
    @Email(message = "Email inválido.")
    private String email;

    @Past(message = "Data de nascimento inválida.")
    private LocalDate data_nascimento;

    @Min(value = 1, message = "O id do personal não pode ser negativo ou zero.")
    private Integer personal;
}
