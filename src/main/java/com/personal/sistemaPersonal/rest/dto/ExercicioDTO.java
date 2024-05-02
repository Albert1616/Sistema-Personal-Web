package com.personal.sistemaPersonal.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExercicioDTO {

    @NotBlank(message = "Campo não informado.")
    private String nome;

    @Positive(message = "Insira um número inteiro positivo.")
    @NotBlank(message = "Campo não informado.")
    private Integer series;

    @Positive(message = "Insira um número inteiro positivo.")
    @NotBlank(message = "Campo não informado.")
    private Integer repeticoes;

    private String observacoes;
}
