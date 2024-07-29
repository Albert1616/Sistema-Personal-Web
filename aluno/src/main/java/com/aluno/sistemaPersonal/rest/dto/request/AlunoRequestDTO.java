package com.aluno.sistemaPersonal.rest.dto.request;

import com.auth.sistemaPersonal.rest.dto.UserRequestDTO;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class AlunoRequestDTO extends UserRequestDTO {
    @NotBlank(message = "Campo não informado.")
    private String nome;

    @NotBlank(message = "Campo não informado.")
    @Email(message = "Email inválido.")
    private String email;

    @Past(message = "Data de nascimento inválida.")
    private LocalDate dataNascimento;
}
