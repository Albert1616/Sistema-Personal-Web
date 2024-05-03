package com.personal.sistemaPersonal.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DietaRequestDTO {

    @NotBlank(message = "Campo não informado.")
    private String titulo;

    @Positive(message = "O valor deve ser um número positivo.")
    private Integer aluno;

    @Positive(message = "O valor deve ser um número positivo.")
    private Integer nutricionista;
}
