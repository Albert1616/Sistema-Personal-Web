package com.personal.sistemaPersonal.rest.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class AvaliacaoFisicaResponseDTO {
    private Integer id;
    private String titulo;
    private LocalDate data;
    private Double alunoPeso;
    private Double alunoAltura;
    private Double medidaBraco;
    private Double medidaPeito;
    private Double medidaPerna;
    private Double medidaCintura;
    private AlunoResponseDTO aluno;
}
