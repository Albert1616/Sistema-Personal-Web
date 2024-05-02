package com.personal.sistemaPersonal.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class AvaliacaoFisicaDTO {

    @NotBlank(message = "Campo não informado.")
    private String titulo;

    @PastOrPresent(message = "Insira uma data passada ou a atual.")
    private LocalDate data;

    @Positive(message = "O id do aluno não pode ser negativo ou zero.")
    private Integer aluno;

    @Positive(message = "Campo não pode ser negativo ou zero.")
    private Double alunoPeso;

    @Positive(message = "Campo não pode ser negativo ou zero.")
    private Double alunoAltura;

    @Positive(message = "Campo não pode ser negativo ou zero.")
    private Double medidaBraco;

    @Positive(message = "Campo não pode ser negativo ou zero.")
    private Double medidaPeito;

    @Positive(message = "Campo não pode ser negativo ou zero.")
    private Double medidaPerna;

    @Positive(message = "Campo não pode ser negativo ou zero.")
    private Double medidaCintura;
}
