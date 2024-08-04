package com.aluno.sistemaPersonal.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Nutricionista extends User {
    private Integer id;

    private String nome;

    private String email;

    private LocalDate dataNascimento;

    private List<Integer> alunos;

    private List<Dieta> dietas;
}
