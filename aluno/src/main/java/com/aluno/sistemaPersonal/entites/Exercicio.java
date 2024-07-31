package com.aluno.sistemaPersonal.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Exercicio {
    private Integer id;

    private String nome;

    private Integer series;

    private Integer repeticoes;

    private String observacoes;
}