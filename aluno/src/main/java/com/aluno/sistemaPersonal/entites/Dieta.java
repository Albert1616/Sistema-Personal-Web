package com.aluno.sistemaPersonal.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Dieta {

    private Integer id;

    private String titulo;

    private Integer aluno;

    private LocalDate data_criacao;

    private Nutricionista nutricionista;

    private List<Refeicao> refeicoes;
}
