package com.personal.sistemaPersonal.rest.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class TreinoDTO {

    @NotBlank(message = "Campo não informado.")
    private String titulo;

    @Positive(message = "O id da ficha de treino deve ser positivo.")
    private Integer FichaTreino;

    @FutureOrPresent(message = "A data de vencimento não pode ser passada.")
    private LocalDate data_vencimento;

    @Positive(message = "O id dos exercicios devem ser positivos.")
    private List<Integer> exercicios;
}