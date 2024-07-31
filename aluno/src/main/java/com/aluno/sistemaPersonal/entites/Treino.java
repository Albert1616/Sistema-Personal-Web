package com.aluno.sistemaPersonal.entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Treino {

    private Integer id;

    private String titulo;

    private FichaTreino ficha_treino;

    private LocalDate data_criacao;

    private LocalDate data_vencimento;

    private List<Exercicio> exercicios;
}
