package com.aluno.sistemaPersonal.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AvaliacaoFisica {

    private Integer id;

    private String titulo;

    private LocalDate data;

    private Integer aluno;

    private Double alunoPeso;

    private Double alunoAltura;

    private Double medidaBraco;

    private Double medidaPeito;

    private Double medidaPerna;

    private Double medidaCintura;
}
